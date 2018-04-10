package cz.czechitas.angrybirds.api;

import javax.swing.*;

public class AngryMatilda extends FourWayPlayer {

    public AngryMatilda(int x, int y) {
        rightImage = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "Matilda-right.png"));
        leftImage = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "Matilda-left.png"));
        downImage = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "Matilda-down.png"));
        upImage = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "Matilda-up.png"));
        setSprite(new JLabel(rightImage), x, y);
        setHunter(true);
        Gameboard.getInstance().addPlayer(this);
    }

}
