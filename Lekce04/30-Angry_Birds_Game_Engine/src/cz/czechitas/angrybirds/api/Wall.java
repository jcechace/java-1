package cz.czechitas.angrybirds.api;

import javax.swing.*;

import cz.czechitas.angrybirds.engine.*;

import static cz.czechitas.angrybirds.api.AngryRed.SPRITE_FOLDER;

public class Wall {

    private ImageIcon image;
    private JComponent sprite;

    public Wall(int x, int y) {
        Utils.invokeAndWait(() -> {
            image = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "wooden-wall.png"));
            sprite = new JLabel(image);
            MainWindow.getInstance().add(sprite, "cell " + x + " " + y);
            MainWindow.getInstance().revalidate();
        });
        Gameboard.getInstance().addWall(this);
    }

    public JComponent getSprite() {
        return sprite;
    }
}
