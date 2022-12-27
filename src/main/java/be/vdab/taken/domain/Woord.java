package be.vdab.taken.domain;

public class Woord {
    private final String woord;

    public Woord(String woord) {
        this.woord = woord;
    }

    public boolean isPalindroom() {
        var woordOmgekeerd = new StringBuilder(woord).reverse().toString();
        return woord.equals(woordOmgekeerd);
    }
}
