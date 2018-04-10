package cz.czechitas.angrybirds.api;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import javax.swing.*;
import cz.czechitas.angrybirds.engine.*;
import net.sevecek.util.*;

import static cz.czechitas.angrybirds.api.Player.SPRITE_FOLDER;

public class Gameboard {

    private static Gameboard instance = new Gameboard();
    private ImageIcon explosionSprite;

    public static Gameboard getInstance() {
        return instance;
    }

    private Gameboard() {
        explosionSprite = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "explosion.png"));
    }

    //-------------------------------------------------------------------------

    private List<Player> allPlayers = new CopyOnWriteArrayList<>();
    private List<Wall> allWalls = new CopyOnWriteArrayList<>();
    private ExecutorService worker = Executors.newCachedThreadPool();
    private Map<Brain, Thread> brainThreads = new ConcurrentHashMap<>();

    synchronized void addPlayer(Player player) {
        allPlayers.add(player);
    }

    synchronized void removePlayer(Player player) {
        stopMoving(player);
        allPlayers.remove(player);
        player.getSprite().setVisible(false);
        showExplosion(player.getSprite());
    }

    private synchronized void showExplosion(JLabel sprite) {
        worker.execute(() -> {
            JLabel explosionComp = new JLabel(explosionSprite);
            Utils.invokeLater(() -> {
                explosionComp.setSize(explosionSprite.getIconWidth(), explosionSprite.getIconHeight());
                explosionComp.setLocation(sprite.getLocation());
                MainWindow.getInstance().add(explosionComp, "external");
                MainWindow.getInstance().repaint();
            });
            ThreadUtils.sleep(1000);
            Utils.invokeLater(() -> {
                MainWindow.getInstance().remove(explosionComp);
                MainWindow.getInstance().revalidate();
                MainWindow.getInstance().repaint();
            });
        });
    }

    synchronized void startMoving(Player player) {
        worker.execute(() -> {
            try {
                Brain brain = player.getBrain();
                brainThreads.put(brain, Thread.currentThread());
                while (!Thread.currentThread().isInterrupted()) {
                    brain.controlPlayer();
                }
            } catch (CancellationException e) {
                // Cancellation just means stop
            }
        });
    }

    synchronized void stopMoving(Player player) {
        Brain brain = player.getBrain();
        if (brain != null) {
            Thread thread = brainThreads.remove(brain);
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    synchronized boolean detectCollisionWithWalls(JLabel sprite) {
        for (Wall wall : allWalls) {
            if (Utils.detectCollision(wall.getSprite(), sprite)) return true;
        }
        return false;
    }

    synchronized void addWall(Wall wall) {
        allWalls.add(wall);
    }

    public synchronized void stop() {
        worker.shutdownNow();
        Thread.currentThread().getThreadGroup().interrupt();
    }

    synchronized void detectCollisionWithOtherPlayers() {
        for (Player player1 : allPlayers) {
            for (Player player2 : allPlayers) {
                if (player1.equals(player2)) continue;

                if (player1.isHunter() && !player2.isHunter() && Utils.detectCollision(player1.getSprite(), player2.getSprite())) {
                    removePlayer(player2);
                    checkWin();
                }
            }
        }
    }

    private void checkWin() {
        boolean existPlayerBeingHunted = false;
        for (Player player : allPlayers) {
            if (!player.isHunter()) {
                existPlayerBeingHunted = true;
            }
        }

        if (!existPlayerBeingHunted) {
            Utils.invokeLater(() -> {
                JLabel message = new JLabel("Game Finished!");
                Font font = message.getFont().deriveFont(50.0F);
                message.setFont(font);
                Dimension size = message.getPreferredSize();
                Container contentPane = MainWindow.getInstance().getContentPane();
                contentPane.add(message, "pos 50%-" + size.getWidth() / 2 + "px 50%-" + size.getHeight() / 2 + "px");
                contentPane.setComponentZOrder(message, 0);
                message.repaint();
            });
        }
    }
}
