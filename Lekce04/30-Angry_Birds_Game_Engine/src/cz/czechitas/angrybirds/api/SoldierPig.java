package cz.czechitas.angrybirds.api;

import javax.swing.*;

public class SoldierPig extends Player {

    private ImageIcon spriteImage;

    public SoldierPig(int x, int y) {
        spriteImage = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "SoldierPig.png"));
        setSprite(new JLabel(spriteImage), x, y);
        setHunter(false);
        Gameboard.getInstance().addPlayer(this);
    }

}
