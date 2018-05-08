package cz.czechitas.citaty;

public class Citat {
    private String author;
    private String text;
    private boolean oblibeny;

    public Citat(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public boolean isOblibeny() {
        return oblibeny;
    }

    public void setOblibeny(boolean newValue) {
        oblibeny = newValue;
    }
}
