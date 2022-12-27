package be.vdab.taken.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ArtikelTest {
    @Test
    @DisplayName("Artikel prijs excl 100 btw percentage 21 geeft prijs incl btw 121.00")
    void prijsInclusiefBtwIsPrijsExclusiefBtwMaalBtwPercentage() {
        assertThat(new Artikel(BigDecimal.valueOf(100), BigDecimal.valueOf(21)).getPrijsInclusiefBtw()).isEqualByComparingTo("121.00");
    }

}
