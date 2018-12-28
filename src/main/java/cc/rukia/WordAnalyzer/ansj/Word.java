package cc.rukia.WordAnalyzer.ansj;

public class Word {
    private String name;
    private int fre;

    public Word(String name, int fre) {
        this.name = name;
        this.fre = fre;
    }

    public Word(String name) {
        this.name = name;
        this.fre = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFre() {
        return fre;
    }

    public void setFre(int fre) {
        this.fre = fre;
    }
}
