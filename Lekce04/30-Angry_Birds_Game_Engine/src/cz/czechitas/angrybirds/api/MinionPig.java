package cz.czechitas.angrybirds.api;

import javax.swing.*;

public class MinionPig extends Player {

    private ImageIcon spriteImage;

    public MinionPig(int x, int y) {
        spriteImage = new ImageIcon(getClass().getResource(SPRITE_FOLDER + "MinionPig.png"));
        setSprite(new JLabel(spriteImage), x, y);
        setHunter(false);
        Gameboard.getInstance().addPlayer(this);
    }

}
