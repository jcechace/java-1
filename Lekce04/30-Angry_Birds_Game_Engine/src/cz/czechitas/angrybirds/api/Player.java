package cz.czechitas.angrybirds.api;

import java.awt.*;
import javax.swing.*;
import cz.czechitas.angrybirds.engine.*;
import net.sevecek.util.*;

public abstract class Player {

    public static final String SPRITE_FOLDER = "/cz/czechitas/angrybirds/engine/images/";
    private JLabel sprite;
    private PlayerOrientation orientation = PlayerOrientation.RIGHT;
    private Brain brain;
    private boolean isHunter;

    public Brain getBrain() {
        return brain;
    }

    public void setBrain(Brain brain) {
        if (brain instanceof UniversalBrain) {
            ((UniversalBrain) brain).setPlayer(this);
        }
        if (this.brain != null) {
            Gameboard.getInstance().stopMoving(this);
        }
        this.brain = brain;
        Gameboard.getInstance().startMoving(this);
    }

    protected PlayerOrientation getOrientation() {
        return orientation;
    }

    protected void setOrientation(PlayerOrientation orientation) {
        this.orientation = orientation;
    }

    public void moveForward() {
        ThreadUtils.sleep(20L);
        Utils.invokeLater(() -> {
            moveForwardInternal();
            sprite.repaint();
        });
    }

    void moveForwardInternal() {
        if (!isPossibleToMoveForward()) return;

        Point location = sprite.getLocation();
        if (getOrientation() == PlayerOrientation.RIGHT) {
            location.x += 5;
        }
        if (getOrientation() == PlayerOrientation.LEFT) {
            location.x -= 5;
        }
        if (getOrientation() == PlayerOrientation.UP) {
            location.y -= 5;
        }
        if (getOrientation() == PlayerOrientation.DOWN) {
            location.y += 5;
        }
        sprite.setLocation(location);

        Gameboard.getInstance().detectCollisionWithOtherPlayers();
    }

    public void turnLeft() {
        ThreadUtils.sleep(10L);
        Utils.invokeLater(() -> {
            switch (getOrientation()) {
                case UP:
                    setOrientation(PlayerOrientation.LEFT);
                    break;
                case LEFT:
                    setOrientation(PlayerOrientation.DOWN);
                    break;
                case DOWN:
                    setOrientation(PlayerOrientation.RIGHT);
                    break;
                case RIGHT:
                    setOrientation(PlayerOrientation.UP);
                    break;
            }
        });
    }

    public void turnRight() {
        ThreadUtils.sleep(10L);
        Utils.invokeLater(() -> {
            switch (getOrientation()) {
                case UP:
                    setOrientation(PlayerOrientation.RIGHT);
                    break;
                case LEFT:
                    setOrientation(PlayerOrientation.UP);
                    break;
                case DOWN:
                    setOrientation(PlayerOrientation.LEFT);
                    break;
                case RIGHT:
                    setOrientation(PlayerOrientation.DOWN);
                    break;
            }
        });
    }

    public boolean isPossibleToMoveForward() {
        return Utils.invokeAndWait(() -> {
            boolean result = true;

            Point location = sprite.getLocation();
            Point originalLocation = new Point(location);
            if (getOrientation() == PlayerOrientation.RIGHT) {
                location.x += 5;
            }
            if (getOrientation() == PlayerOrientation.LEFT) {
                location.x -= 5;
            }
            if (getOrientation() == PlayerOrientation.UP) {
                location.y -= 5;
            }
            if (getOrientation() == PlayerOrientation.DOWN) {
                location.y += 5;
            }

            if (location.x < 0 || location.y < 0
                    || location.x + sprite.getWidth() > sprite.getParent().getWidth()
                    || location.y + sprite.getHeight() > sprite.getParent().getHeight()) {
                result = false;
            }

            sprite.setLocation(location);
            if (Gameboard.getInstance().detectCollisionWithWalls(sprite)) {
                result = false;
            }
            sprite.setLocation(originalLocation);
            return result;
        }).booleanValue();
    }

    protected JLabel getSprite() {
        return sprite;
    }

    protected void setSprite(JLabel sprite, int x, int y) {
        this.sprite = sprite;
        MainWindow.getInstance().add(sprite, "cell " + x + " " + y);
        MainWindow.getInstance().revalidate();
        MainWindow.getInstance().externFromMigLayout(sprite);
        MainWindow.getInstance().revalidate();
    }

    public void setHunter(boolean isPlayerHuntingOthers) {
        this.isHunter = isPlayerHuntingOthers;
    }

    public boolean isHunter() {
        return isHunter;
    }
}
