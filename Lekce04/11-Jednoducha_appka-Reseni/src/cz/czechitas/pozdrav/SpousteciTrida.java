package cz.czechitas.pozdrav;

import java.awt.*;
import java.time.*;
import java.util.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        String jmeno;
        int vek;

        jmeno = "Kamil";
        vek = 36;

        System.out.println("Ahoj, zdravi ");
        System.out.println( jmeno );
        System.out.println("Jeho stari je ");
        System.out.println( vek );

        Color zluta;
        LocalDate dneska;

        zluta = new Color(255, 255, 0);
        System.out.println(zluta);

//        LocalDate dneska = new LocalDate(2018, 1, 28);
        dneska = LocalDate.of(2018, 1, 27);
        System.out.println("Dnes je ");
        System.out.println(dneska);
    }

}
