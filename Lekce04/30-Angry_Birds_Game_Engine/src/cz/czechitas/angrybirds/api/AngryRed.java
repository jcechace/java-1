package cz.czechitas.angrybirds.api;

import javax.swing.*;

public class AngryRed extends FourWayPlayer {

    public AngryRed(int x, int y) {
        rightImage = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "Red-right.png"));
        leftImage = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "Red-left.png"));
        downImage = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "Red-down.png"));
        upImage = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "Red-up.png"));
        setSprite(new JLabel(rightImage), x, y);
        setHunter(true);
        Gameboard.getInstance().addPlayer(this);
    }

}
