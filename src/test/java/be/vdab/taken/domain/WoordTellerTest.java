package be.vdab.taken.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class WoordTellerTest {
    private WoordTeller woordTeller;
    @BeforeEach
    void beforeEach() {
        woordTeller = new WoordTeller();
    }
    @Test
    void nullAlsArgumentIsNietToegelaten() {
        assertThatNullPointerException().isThrownBy(
                () -> woordTeller.aantalWoordenInEenZin(null)
        );
    }
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "   ", ",", ", ", ",,,", " , ,, " })
    void aantalWoordenIsNul(String tekst) {
        assertThat(woordTeller.aantalWoordenInEenZin(tekst)).isZero();
    }
    @ParameterizedTest
    @ValueSource(strings = { "woord", "woord ", " woord"})
    void aantalWoordenIsEen(String tekst) {
        assertThat(woordTeller.aantalWoordenInEenZin(tekst)).isOne();
    }
    @ParameterizedTest
    @ValueSource(strings = { "twee woorden", "twee  woorden", "twee,woorden", "twee, woorden", "twee , woorden" })
    void aantalWoordenIsTwee(String tekst) {
        assertThat(woordTeller.aantalWoordenInEenZin(tekst)).isEqualTo(2);
    }
}