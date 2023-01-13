package be.vdab.taken.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PeriodeTest {
    private LocalDate datum01012023;
    private LocalDate datum08012023;
    private Periode periode1;
    private Periode periode2;
    @BeforeEach
    void beforeEach() {
        datum01012023 = LocalDate.of(2023, 1, 1);
        datum08012023 = LocalDate.of(2023, 1, 8);
        periode1 = new Periode(datum01012023, datum08012023);
        periode2 = new Periode(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 8));
    }
    @Test
    void vanMagNietNullZijn() {
        assertThatNullPointerException().isThrownBy(
                () -> new Periode(null, datum08012023)
        );
    }
    @Test
    void totMagNietNullZijn() {
        assertThatNullPointerException().isThrownBy(
                () -> new Periode(datum01012023, null)
        );
    }
    @Test
    void eenLaterePeriodeKomtNaEenVroegerePeriode() {
        assertThat(periode2.komtNa(periode1)).isTrue();
    }
    @Test
    void eenVroegerePeriodeKomtNietNaEenLaterePeriode() {
        assertThat(periode1.komtNa(periode2)).isFalse();
    }
    @Test
    void argumentPeriodeInKomtNaMoetIngevuldZijn() {
        assertThatNullPointerException().isThrownBy(
                () -> periode1.komtNa(null)
        );
    }
    @Test
    void argumentPeriodeInOverlaptMetMoetIngevuldZijn() {
        assertThatNullPointerException().isThrownBy(
                () -> periode1.overlaptMet(null)
        );
    }
    @Test
    void totMoetGroterOfGelijkZijnAanVan() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Periode(datum08012023, datum01012023)
        );
    }
    @Test
    void eenPeriodeVanEenDagIsToegelaten() {
        new Periode(datum01012023, datum01012023);
    }
    @Test
    void wanneerVanGelijkIsKomtDeEnePeriodeNietNaDeAndere() {
        assertThat(new Periode(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 20))
                .komtNa(periode1)).isFalse();
    }
    @Test
    void eenPeriodeOverlaptMetZichzelf() {
        assertThat(periode1.overlaptMet(periode1)).isTrue();
    }
    @Test
    void eenPeriodeOverlaptNietMetEenPeriodeDieLaterKomt() {
        assertThat(periode1.overlaptMet(periode2)).isFalse();
    }
    @Test
    void eenPeriodeOverlaptNietMetEenPeriodeDieVroegerKomt() {
        assertThat(periode2.overlaptMet(periode1)).isFalse();
    }
    @Test
    void eenPeriodeOverlaptMetEenPeriodeMetEenVanBinnenDeEerstePeriode() {
        assertThat(periode1.overlaptMet(new Periode(LocalDate.of(2023, 1, 5),
                LocalDate.of(2023, 1, 25)))).isTrue();
    }
    @Test
    void eenPeriodeOverlaptMetEenPeriodeMetEenTotBinnenDeEerstePeriode() {
        assertThat(periode2.overlaptMet(new Periode(LocalDate.of(2023, 1, 18),
                LocalDate.of(2023, 2, 5)))).isTrue();
    }
    @Test
    void eenPeriodeOverlaptMetEenPeriodeDieVolledigBinnenDeEerstePeriodeValt() {
        assertThat(periode1.overlaptMet(new Periode(LocalDate.of(2023, 1, 3),
                LocalDate.of(2023, 1, 6)))).isTrue();
    }
    @Test
    void tweePeriodesMetGelijkeVanOverlappen() {
        assertThat(periode1.overlaptMet(new Periode(LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 7, 8)))).isTrue();
    }
    @Test
    void tweePeriodesMetGelijkeTotOverlappen() {
        assertThat(periode2.overlaptMet(new Periode(LocalDate.of(2023, 1, 10),
                LocalDate.of(2023, 2, 8)))).isTrue();
    }

}