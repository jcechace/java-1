package cz.czechitas.okna;

import java.awt.*;
import javax.swing.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        JFrame okno;
        JLabel napis;
        Font vetsiFont;

        okno = new JFrame("Dnesni datum");
        okno.setLocation(200, 200);
        okno.setSize(400, 300);
        okno.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        vetsiFont = new Font("Tahoma", Font.PLAIN, 20);

        napis = new JLabel("Dneska je 27. 1. 2018");
        napis.setHorizontalAlignment(SwingConstants.CENTER);
        napis.setFont(vetsiFont);
        okno.add(napis);

        okno.setVisible(true);
    }

}
