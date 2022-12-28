package be.vdab.taken.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RechthoekTest {
    private Rechthoek rechthoek;
    @BeforeEach
    void beforeEach() {
        rechthoek = new Rechthoek(5, 4);
    }
    @Test
    void deOppervlakteVanEenRechthoekVan5Op4Is20() {
        assertThat(rechthoek.getOppervlakte()).isEqualTo(20);
    }
    @Test
    void deOmtrekVanEenRechthoekVan5Op4Is18() {
        assertThat(rechthoek.getOmtrek()).isEqualTo(18);
    }
    @Test
    void tweeRechthoekenZijnGelijkWanneerLengteEnBreedteGelijkZijn() {
        assertThat(rechthoek).isEqualTo(new Rechthoek(5, 4));
    }
    @Test
    void tweeRechthoekenZijnVerschillendWanneerLengteOfBreedteVerschillendZijn() {
        assertThat(rechthoek).isNotEqualTo(new Rechthoek(5, 6));
        assertThat(rechthoek).isNotEqualTo(new Rechthoek(6, 4));
    }
    @Test
    void tweeRechthoekenMetDezelfdeAfmetingenGevenDezelfdeHashcode() {
        assertThat(rechthoek).hasSameHashCodeAs(new Rechthoek(5, 4));
    }

}
