package cz.czechitas.angrybirds.api;

import javax.swing.*;

public abstract class FourWayPlayer extends Player {
    protected ImageIcon leftImage;
    protected ImageIcon downImage;
    protected ImageIcon upImage;
    protected ImageIcon rightImage;

    @Override
    public void setOrientation(PlayerOrientation orientation) {
        super.setOrientation(orientation);
        switch (orientation) {
            case UP:
                getSprite().setIcon(upImage);
                break;
            case DOWN:
                getSprite().setIcon(downImage);
                break;
            case LEFT:
                getSprite().setIcon(leftImage);
                break;
            case RIGHT:
                getSprite().setIcon(rightImage);
                break;
        }
    }

}
