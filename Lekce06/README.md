Lekce 06
========

Událost kliknutí na tlačítko
----------------------------

### Osnova

1. Domácí úkol (metody se vstupními parametry)
1. Události, reakce na události
1. Událost actionPerformed (stisk tlačítka)
1. Programování aplikace Pozdrav
1. Programování aplikace Fahrenheit -> Celsius
1. Programování aplikace Husy a králíci (Domácí úkol)

### Videozáznam

Na YouTube se můžete podívat na [záznam z lekce z minulého roku](https://www.youtube.com/watch?v=vgKaaYj-qhQ),

Úkol - Uživatelské aplikace a události
--------------------------------------

Cílem domácího úkolu je naprogramovat jednoduchou aplikaci s uživatelským rozhraním a reakcemi na události.

### Část 1 - Farmářka 1.0

Vytvoře aplikaci Farmářka určenou pro správu zvířat (hus a králíků). První verze aplikace načte od uživtele informaci o tom, kolik hus a králíku je na farmě a následně vypíše infomraci o celkovém počtu zvířecích hlav a nohou na farmě.

Jak by mohla aplikace přibližně vypadat můžete vidět níže, nebojte se však být kreativní.

Jelikož v aplikaci budeme načítat pouze celá čísla (datový typ ``int``), lze text načtený z edit boxu převést na číslo jako

```java
String text = ...
int cislo = Integer.parseInt(text);
```

Pro zkontrolování zda text obsahuje číslo lze použít následující metodu

```java
public boolean jeCeleCislo(String text) {
    try {
        Integer.parseInt(text);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}    
```

### Část 2 - Farmářka 2.0

Jako správné farmářky se musíte o chov dobře starat a v létě
vypěstovat dostatek potravy pro zvířata na zimu. V létě zvířata žerou čerstvou travičku, proto potřebujete potravu jen
na zimní období, což (pro zjednodušení) považujme za dobu půl roku (půl roku je 365 dní děleno 2, tedy přibližně 183
dní).

Králíci žerou přes zimu mrkev, husy zrní. Jeden králík sní ½ kg mrkve denně a jedna husa ¼ kg zrní. Potřebujete tedy
183*0.5 kg mrkve na každého králíka a 183*0.25 kg zrní na každou husu.

Z jednoho řádku mrkve můžete sklidit 5 kg mrkve. Z jednoho řádku pšenice sklidíte 2 kg. Kolik musíte zasadit řádků mrkve
a kolik pšenice, abyste měly dost potravy na zimu?

![](ukol06-husy1.png)

### Část 3 - Farmářka 2.5 

Až to budete mít hotové, udělejte ještě vylepšenou verzi. Máte-li v chovu alespoň 1 samici a 1 samce, můžete čekat, že
se vám chov do zimy rozšíří a měly byste tedy vypěstovat víc potravy. Pokud tedy v aplikaci zadáte, že máte 1 samce
králíka a 1 či více samic, musíte počítat s tím, že za léto bude mít každá samice průměrně 40 mláďat. U hus to bude
obdobné, za léto může mít jedna husa 15 housat. (Přes zimu se zvířátka na farmě nerozmnožují).

![](ukol06-husy2.png)

#### Rady na cestu

Až naprogramujete jednodušší zadání bez rozmnožování chovu, rozšiřte program o zadání počtu samců a samic místo pouze
počtu kusů králíků a hus. Ve výpočtech zohledněte jejich množení.

Do velikosti chovu nezapomeňte kromě mláďat připočíst i původní samce a samice. Nezapomeňte také ohlídat, že se chov
nemůže rozmnožovat, pokud nemáte samce nebo samici.

Pozor při dělení **int**u **int**em (např. 11/2) vyjde opět **int** a zaokrouhluje se odtržením desetinných
míst. Doporučujeme pro dělení používat **double**.

```java
	int a = ...
	int b = ...
	double c = ((double) a) / b
```

Narozdíl od příkladu v hodině lze v tomto případě (desetiné číslo nenačítáme od uživatele) provést převod z **double** na **String** jednoduše:

```java
    double cislo = ...
    String text = Double.toString(cislo);
```

Pokud budete mít s úkolem jakýkoliv problém, využjte naši facebookovou skupinu, kde vám rádi poradíme. Raději se 10x
zeptejte, než abyste to vzdaly.

### Odevzdání domácího úkolu

Domácí úkol (složky s projekty) zabalte pomocí 7-Zipu pod jménem **Ukol05-Vase_Jmeno.7z**. (Případně lze použít prostý
zip, například na Macu). Takto vytvořený archív nahrajte na Google Drive do složky Ukol06.

Vytvořte snímek obrazovky spuštěného programu a pochlubte se s ním v galerii na Facebooku.

Pokud byste chtěli odevzdat revizi úkolu (např. po opravě), zabalte ji a nahrajte ji na stejný Google Drive znovu, jen
tentokrát se jménem **Ukol05-Vase_Jmeno-verze2.7z**.
