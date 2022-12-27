package be.vdab.taken.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RechthoekTest {
    @Test
    void deOppervlakteVanEenRechthoekVan5Op4Is20() {
        assertThat(new Rechthoek(5, 4).getOppervlakte()).isEqualTo(20);
    }
    @Test
    void deOmtrekVanEenRechthoekVan5Op4Is18() {
        assertThat(new Rechthoek(5, 4).getOmtrek()).isEqualTo(18);
    }

}
