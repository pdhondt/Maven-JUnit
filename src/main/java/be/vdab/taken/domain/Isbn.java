package be.vdab.taken.domain;

public class Isbn {
    private final long nummer;
    public Isbn(long nummer) {
        if (nummer <= 0) {
            throw new IllegalArgumentException("Nummer moet positief zijn");
        }
        if (String.valueOf(nummer).length() != 13) {
            throw new IllegalArgumentException("Nummer moet 13 cijfers lang zijn");
        }
        var eersteDrieCijfers = nummer / 10_000_000_000L;
        if (!(eersteDrieCijfers == 978 || eersteDrieCijfers == 979)) {
            throw new IllegalArgumentException("Eerste drie cijfers moeten 978 of 979 zijn");
        }
        var controleGetal = nummer % 10;
        var cijfersVoorControle = nummer / 10;
        var somEven = 0L;
        var somOneven = 0L;
        for (var i = 0; i != 6; i++) {
            somEven += cijfersVoorControle % 10;
            cijfersVoorControle /= 10;
            somOneven += cijfersVoorControle % 10;
            cijfersVoorControle /= 10;
        }
        var som = somOneven + (somEven * 3);
        var hogerGelegenTiental = som + (10 - (som % 10));
        var verschil = hogerGelegenTiental - som;
        verschil = verschil == 10 ? 0 : verschil;
        if (!(verschil == controleGetal)) {
            throw new IllegalArgumentException("Geen geldig ISBN nummer");
        }
        this.nummer = nummer;
    }
    @Override
    public String toString() {
        return String.valueOf(nummer);
    }
}
