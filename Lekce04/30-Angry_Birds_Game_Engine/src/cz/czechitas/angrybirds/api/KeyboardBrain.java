package cz.czechitas.angrybirds.api;

import java.awt.event.*;
import cz.czechitas.angrybirds.engine.*;
import net.sevecek.util.*;
import net.sevecek.util.swing.*;

public class KeyboardBrain implements UniversalBrain {

    private final int keyCodeLeft;
    private final int keyCodeUp;
    private final int keyCodeRight;
    private final int keyCodeDown;
    private Player player;

    public KeyboardBrain() {
        this(KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN);
    }

    public KeyboardBrain(int keyCodeLeft, int keyCodeUp, int keyCodeRight, int keyCodeDown) {
        this.keyCodeLeft = keyCodeLeft;
        this.keyCodeUp = keyCodeUp;
        this.keyCodeRight = keyCodeRight;
        this.keyCodeDown = keyCodeDown;
    }

    @Override
    public void controlPlayer() {
        ThreadUtils.sleep(20L);
        Utils.invokeLater(() -> {
            JKeyboard keyboard = MainWindow.getInstance().getKeyboard();
            if (keyboard.isKeyDown(keyCodeUp)) {
                player.setOrientation(PlayerOrientation.UP);
                player.moveForwardInternal();
            }
            if (keyboard.isKeyDown(keyCodeDown)) {
                player.setOrientation(PlayerOrientation.DOWN);
                player.moveForwardInternal();
            }
            if (keyboard.isKeyDown(keyCodeLeft)) {
                player.setOrientation(PlayerOrientation.LEFT);
                player.moveForwardInternal();
            }
            if (keyboard.isKeyDown(keyCodeRight)) {
                player.setOrientation(PlayerOrientation.RIGHT);
                player.moveForwardInternal();
            }
            player.getSprite().repaint();
        });
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
