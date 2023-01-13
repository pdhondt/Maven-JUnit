package be.vdab.taken.domain;

import java.time.LocalDate;

public class Periode {
    private final LocalDate van;
    private final LocalDate tot;
    public Periode(LocalDate van, LocalDate tot) {
        if (tot.isBefore(van)) {
            throw new IllegalArgumentException();
        }
        this.van = van;
        this.tot = tot;
    }
    public boolean komtNa(Periode periode) {
        return van.isAfter(periode.tot);
    }
    public boolean overlaptMet(Periode periode) {
        return !tot.isBefore(periode.van) && !van.isAfter(periode.tot);
    }
}
