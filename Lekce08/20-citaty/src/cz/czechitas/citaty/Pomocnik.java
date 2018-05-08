package cz.czechitas.citaty;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Pomocnik {

    /**
     * Metoda nacte radky ze souboru na dane ceste
     * 
     * @param cesta cesta k souboru ktery chceme cist
     * @return Seznam radku nebo prazdny seznam pokud nastala chyba
     */
    public List<String> nactiRadkySouboru(Path cesta) {
        try {
            return Files.readAllLines(cesta);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    /**
     * Metoda zapise radky do souboru
     * @param radky seznam jednotlivych radku
     * @param cesta cesta k souboru do ktereho budeme zapisovat
     */
    public void zapisRadkyDoSouboru(List<String> radky, Path cesta) {
        String obsah = String.join(System.lineSeparator(), radky);
        try {
            Files.write(cesta, obsah.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
