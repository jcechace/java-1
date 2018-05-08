package cz.czechitas.citaty.zdroje;

import java.util.*;
import cz.czechitas.citaty.*;

public class StatickyZdrojCitatu implements ZdrojCitatu {
    private List<Citat> citaty;

    public StatickyZdrojCitatu() {
        citaty = new ArrayList<>();
        pridejCitat("Abraham Lincoln", "A house divided against itself cannot stand.");
        pridejCitat("Carl Sandburg", "Nothing happens unless first we dream.");
        pridejCitat("Aristotle", "Well begun is half done.");
        pridejCitat("Karen Clark", "Life is change. Growth is optional. Choose wisely.");
        pridejCitat("", "Every man dies. Not every man really lives.");
        pridejCitat("Lao Tzu", "To lead people walk behind them.");
        pridejCitat("William Shakespeare", "Having nothing, nothing can he lose.");
        pridejCitat("Anička", "Nechápu lidi co můžou říct že se nudí.");
        pridejCitat("Dave Weinbaum", "The secret to a rich life is to have more beginnings than endings.");
        pridejCitat("Anička", "Kde seženu v Brně jednorožce?");
        pridejCitat("Napoleon Hill", "Ideas are the beginning points of all fortunes.");
        pridejCitat("Publilius Syrus", "A rolling stone gathers no moss.");
        pridejCitat("Anička", "Proč má den jen 24 hodin?");
        pridejCitat("Annie Dillard", "How we spend our days is, of course, how we spend our lives.");
        pridejCitat("Henry Ford", "If you think you can, you can. And if you think you can't, you're right.");
        pridejCitat("Jakub", "Už radši nebudu přidávat další citáty.");
    }

    @Override
    public List<Citat> getCitaty() {
        return citaty;
    }

    private void pridejCitat(String autor, String text) {
        citaty.add(new Citat(autor, text));
    }
}
