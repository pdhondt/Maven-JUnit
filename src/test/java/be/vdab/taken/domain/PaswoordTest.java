package be.vdab.taken.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PaswoordTest {
    @Test
    void paswoordPeter987IsCorrect() {
        new Paswoord("Peter987");
    }
    @ParameterizedTest
    @ValueSource(strings = { "peter987", "PETER987", "Peter98", "peterdho" })
    void foutievePaswoorden(String waarde) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Paswoord(waarde));
    }
    @Test
    void getPuntjesVoorPeter987GeeftEenStringMet8PuntjesTerug() {
        assertThat(new Paswoord("Peter987").getPuntjes()).isEqualTo("........");
    }
    @Test
    void nullAlsArgumentIsNietToegelaten() {
        assertThatNullPointerException().isThrownBy(
                () -> new Paswoord(null)
        );
    }
    @Test
    void paswoordPeter987KomtOvereenMetPaswoordPeter987() {
        assertThat(new Paswoord("Peter987").komtOvereenMet("Peter987")).isTrue();
    }
}