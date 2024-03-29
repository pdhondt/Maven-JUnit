package be.vdab.taken.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class VeilingTest {
    private Veiling veiling;
    @BeforeEach
    void beforeEach() {
        veiling = new Veiling();
    }
    @Test
    @DisplayName("Wanneer er nog geen bod gedaan is, is het hoogste bod 0")
    void hoogsteBodIsGelijkAan0WanneerNogGeenBodGedaanIs() {
        assertThat(veiling.getHoogsteBod()).isZero();
    }

    @Test
    @DisplayName("Wanneer een bod het eerste bod is (hier 10€), is hoogste bod gelijk aan dit bod (10€)")
    void hoogsteBodIsGelijkAanBodWanneerBodHetEersteBodIs() {
        veiling.doeBod(BigDecimal.TEN);
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo("10");
    }

    @Test
    @DisplayName("Wanneer je meerdere keren een bod doet (30, 50, 20), is het hoogste bod gelijk aan het hoogste bedrag (50)")
    void hoogsteBodIsGelijkAanHoogsteBedragWanneerJeMeerdereKerenEenBodDoet() {
        veiling.doeBod(BigDecimal.valueOf(30));
        veiling.doeBod(BigDecimal.valueOf(50));
        veiling.doeBod(BigDecimal.valueOf(20));
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo("50");
    }
}