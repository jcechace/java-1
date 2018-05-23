# Domácí úkol č. 6

Při programování se snažte vyhýbat opakování kódu vhodným využíváním metod.

Například si budete moci věimnout, že všechny metody pro zobrazení náhodného citátu (ze všech, od autora, oblíbeného) fungují tak, že nejprve vyberou vhodné citáty ze zdroje (například všechny od urřitého autora) a následně v druhém kroku z této části vyberou náhodný citát. Právě druhý krok bude stejný pro všechny metody zobrazující náhodný citát.

## Náhodný citát od autora
- Tlačítko po kliknuti zobrazí náhodný citát od stejného autora jako aktuálně zobrazený citát.

### Tip 1
Jistě víte, že k porovnávání slouží operátor == . Funguje však pouze pro primitivní hodnoty typu ``int``, ``double``, ``char``, etc...
Objekty (například typy ``String``) je potřeba orovnávat jinak.

```java
public boolean jeJakub(String jmeno) {
    bool jeJakub = jmeno.equals("Jakub"));
    return jeJakub;
}
```

### Tip 2
Kromě klasického for cyklu existuje i speciální varianta pro procházení prvků v seznamech.

```java
List<String> texty;

for (String text : texty) {
    // Tady muzu udelat neco s jednolivymi objekty ze seznamu
    System.out.printl(text);
}
```

## Ukazatel počtu autorů
 - Vedle celkového počtu citátu zobraz i počet autorů v aktuálním zdroji citátů.

### Tip
Z hodiny znáte datovou strukturu seznam (``List``) a víte jak s ním pracovat.

```java
    List<String> jmena = new ArrayList();
    jmena.add("Jakub");
    jmena.add("Jakub");
    jmena.add("Honzik");
    jmena.add("Anicka");

    int pocet = jmena.size();

    // vypise 4 (V seznamu jsou dva Jakubove, jedna Anicka, a Honzik)
    System.out.println(pocet);

    // prvky v seznamu maji urcene poradi. Anicka je 3. v seznamu
    System.out.println(jmena.get(3))

    // Muzeme pouzit for-each
    for (String jmeno : jmena) {
        // Postupne vypise vsechna jmena (poradi bude pokazde stejne).
        System.out.printl(jmeno);
    }
```

Kromě seznamu má Java i datovou strukturu jménem množina (``Set``). Od seznamu se liší tím, že prvky v ní nemají pořadí. Další rozdíl je, že prvky v množině jsou unikátní.

```java
    Set<String> jmena = new HashSet();
    mena.add("Jakub");
    jmena.add("Jakub");
    jmena.add("Honzik");
    jmena.add("Anicka");

    int pocet = jmena.size();

    // vypise 3 (V seznamu jsou 3 unikatni jmena: Jakub, Anicka, Honzik)
    System.out.println(pocet);

    // Prvky v mnozine nemaji poradi, nasledujici radek nebude fungovat
    System.out.println(jmena.get(3));

    // Ale muzeme pouzit for-each
    for (String jmeno : jmena) {
        // Postupne vypise vsechna jmena (poradi muze byt pokazde ruzne)
        System.out.printl(jmeno);
    }
```

## Označ citát jako oblibený
- Do třídy ``Citat`` přidejte atribut typu ``boolean`` jménem ``oblibene``.
  - pro tento atribut vytvořte metodu ``isObliblene`` vracející jeho hodnotu
  - pro tento atribut vytvořte pro tento atribut vytvořte metody ``public void setOblibene(boolean oblibene)`` nastavující jeho hodnotu
  - při zobrazení citátu by měl stav checkboxu ``chckOblibene`` odpovidat hodnotě atributu v objektu citátu
  - implementuj akci, která umožní pomocí checkboxu ``chckOblibene`` oznařit citát za oblíbený
  - výchozí hodnota atributu ``oblibene`` by měla být ``false`` pokud není známá jiná hodnota.

  V souboru citaty.txt je každý citát uložen na 3 řádky.
  Druhý řádek v trojici má hodnotu ``1`` pokud je citát oblíbený,nebo ``0`` pokud není. Zohledněte tuto hodnotu při načítání Citatu ze souboru.

## Zobraz náhodný oblibený citát
Do Aplikace přidejte tlačítko, které po kliknutí zobrazí náhodný oblibený citát

## Bonus: Ulož citáty zpět do souboru.
Implementuje akci, po kliknutí na položku ``Uložit`` v menu ``Soubor`` uloží aktuálně načtené citáty do souboru.
Pro výběr lokace, kam se citáty uloží, použijte standardní dialog pro uložení souboru.

Zobrazení ukládacího dialogu je velmi podobné otevření souboru
```java
    int vysledek = vyberovyDialog.showSaveDialog(this);
    if(vysledek == JFileChooser.APPROVE_OPTION) {

    }
```

Do ```CitacniSluzba``` přidejte metodu, která skutečně uloží citáty do souboru. Nezapomeňte zachovat spravný formát dat. Pro uložení jednotlivých řádků využíjte metodu ```zapisRadkyDoSouboru``` ze třídy ```Pomocník```. Nezapomeňte že této metodě je potřeba předat seznam všech řádků, které chcete do souboru zapsat.

