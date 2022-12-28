package be.vdab.taken.domain;

import java.util.Objects;

public class Rechthoek {
    private final int lengte;
    private final int breedte;

    public Rechthoek(int lengte, int breedte) {
        this.lengte = lengte;
        this.breedte = breedte;
    }

    public int getOppervlakte() {
        return lengte * breedte;
    }

    public int getOmtrek() {
        return 2 * (lengte + breedte);
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof Rechthoek r && lengte == r.lengte && breedte == r.breedte ;
    }
    @Override
    public int hashCode() {
        return Objects.hash(lengte, breedte);
    }
}
