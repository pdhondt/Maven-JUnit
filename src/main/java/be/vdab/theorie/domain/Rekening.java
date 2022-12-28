package be.vdab.theorie.domain;

import java.math.BigDecimal;

public class Rekening {
    private BigDecimal saldo = BigDecimal.ZERO;
    public void stort(BigDecimal bedrag) {
        if (bedrag.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bedrag moet positief zijn");
        }
        saldo = saldo.add(bedrag);
    }
    public BigDecimal getSaldo() {
        return saldo;
    }
}
