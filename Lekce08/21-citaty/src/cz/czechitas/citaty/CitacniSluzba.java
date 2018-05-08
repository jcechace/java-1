package cz.czechitas.citaty;

import java.util.*;
import java.util.stream.*;
import cz.czechitas.citaty.zdroje.*;

public class CitacniSluzba {

    private ZdrojCitatu zdrojCitatu;

    public CitacniSluzba(ZdrojCitatu zdrojCitatu) {
        this.zdrojCitatu = zdrojCitatu;
    }

    private Citat getNahodnyCitatZListu(List<Citat> citaty) {
        Random rand = new Random();
        int i = rand.nextInt(citaty.size());
        return citaty.get(i);
    }

    public Citat getAutoruvCitat(String author) {
        List<Citat> citaty = zdrojCitatu.getCitaty();
        List<Citat> odAutora = new ArrayList<>();

        for(Citat q : citaty) {
            if (q.getAuthor().equals(author)) {
                odAutora.add(q);
            }
        }
        
        return getNahodnyCitatZListu(odAutora);
    }

    public Citat getNahodnyCitat() {
        List<Citat> citaty = zdrojCitatu.getCitaty();
        return getNahodnyCitatZListu(citaty);
    }

    public int getPocetCitatu() {
        return zdrojCitatu.getCitaty().size();
    }

    public int getPocetAutoru() {
        return zdrojCitatu.getCitaty().stream().map(c -> c.getAuthor()).collect(Collectors.toSet()).size();
    }

}
