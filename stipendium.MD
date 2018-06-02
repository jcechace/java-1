Knižní Katalog: projekt pro stipendium Czechitas
===

Aplikaci odevzdejte do odevzdávárny nejpozději do **17.6.2018, 24:00** pro případnou možnost opravy.
Nejzažší možný termín, kdy bude možnost odevzdat je **22.6.2018, 24:00**.

Následující zadání berte spíše orientačně, nebojte se popustit uzdu fantasii a experimentovat.
Cílem je vytvořit aplikaci komplexností podobnou Citátům, ne přesně dodržet zadání níže.

Doporučuji začít s následujícím [projektem](https://drive.google.com/open?id=1jUd_w5f7CHmNYdmTnTnCzwWu2rkdi4JY).

## Obecné zadání
Cílem je vytvořit desktopovou aplikaci, která umožni prochazet a hodnoti seznam knížek.
Informace o knížkách budou načítány ze souboru, kterž bude možno vybrat pomoci standardního dialogu pro otevření souboru.

Aplikace by tedy měla umět následující funkcionalitu

* Načtení informací o knihách ze souboru
* Zobrazit detaily o knižce podle jména (Není nutné celé, měl by stačit začátek)
* Zobrazit detaily o náhodné knížce
* Ohodnotit knížku známkou 1-5
* Uložit načtené knížky do souboru.
* Na spodní straně okna zobrazte celkový počet knih, a jazyků v nichž jsou napsány.

Vzhled i dodatečné funkce v Aplikaci jsou pouze na vás.

**Tip:**
Objekty typu ``String`` maji metodu ``startsWith``

# Uživatelské rozhraní
Tentokrát je pouze na vás, jak bude aplikace vypadat. Navrhněte UI s použitím JFormDesigner

## Formát dat v souboru
Každá kniha je v načítaném souboru uložena na jednom řádku.
Formát řádku je následující

``` Titul;Autor;Rok vydaní;Pocet stran;Jazyk;Obrazek ```


### Reprezentace knihy
Vytvořte třídu ``Kniha`` s atributy pro titul, autor, jazyk, rok vydani, pocet stran, hodnoceni a obrazek.
Vhodně použíjte datový typ pro celé číslo nebo textový řetězec.

Všechny atributy kromě hodnocení a obrázku by mělo být možné nastavit pomocí konstruktoru.
Pro všechny atributy vytvořte getter metody (tedy například ``getPocetStran``).
Pro obrázek a hodnocení vytvořte setter metodu.

### Přístup k datům

Vytvořte třídu ``SouborovyZdrojDat``, která bude představovat konkréní zdroj knižních dat načítaných ze souboru (tzn. třída bude takzvaně implementovat rozhraní ``ZdrojDat``).
Z rozhraní ``ZdrojDat`` víme, že tato třída musí mít minimálně jednu metodu ``getKnihy``, která vrátí seznam knih načtených ze souboru.

**Tip:**

> Data ze souboru načtěte v konstruktoru a uložte to atribitu ``knihy``, ktery bude typu seznam knih.
> Jako zdroj inspirace velice dobře poslouží třída ``SouborovyZdrojCitatu`` z aplikace Citáty.


### Komplexní funkcionalita
Vytvořte třídu ``KnihovniSluzna``, ktera bude obsahovat metody pro získání náhodné knihy, knihy od určitého autora, atd...

**Tip:**
> Jako zdroj inspirace velice dobře poslouží třída ``CitacniSluzba`` z aplikace Citáty.


## Načtení dat ze souboru

K přečtení jednotlivých řádků můžete použí metodu ``nactiRadkySouboru`` ze třídy ``Pomocnik``.
Každý řádek můžete následně rozdělit na jednotlivé složky pomocí metody ``rozdelRadek`` opět ze třídy ``Pomocnik``.

**Tip:**

> metoda ``rodelRadek`` vrací seznam textových řetězců. Nezapomeň, že čísla (například počet stran), bude potřeba převést na správný datový typ.




