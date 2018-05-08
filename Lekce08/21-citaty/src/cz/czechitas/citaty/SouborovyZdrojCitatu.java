package cz.czechitas.citaty;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import cz.czechitas.citaty.zdroje.*;

public class SouborovyZdrojCitatu implements ZdrojCitatu {

    private Path cesta;
    private List<Citat> citaty;
    private Pomocnik pomocnik;

    public SouborovyZdrojCitatu(String odkud) {
        pomocnik = new Pomocnik();
        cesta = Paths.get(odkud);
        citaty = nactiCitaty();
    }

    private List<Citat> nactiCitaty() {
        List<String> lines = pomocnik.nactiRadkySouboru(cesta);
        List<Citat> citaty = new ArrayList<>(lines.size() / 2);

        for (int i = 0; i <  lines.size(); i += 3) {
            String author = lines.get(i);
            String text = lines.get(i+2);
            Citat citat = new Citat(author, text);
            citaty.add(citat);
        }

        return citaty;
    }

    public List<Citat> getCitaty() {
        return citaty;
    }
}
