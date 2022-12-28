package be.vdab.theorie.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class JaarTest {
    @Test
    @DisplayName("Een jaar deelbaar door 400 is een schrikkeljaar.")
    void eenJaarDeelbaarDoor400IsEenSchrikkeljaar() {
        var jaar = new Jaar(2000);
        assertThat(jaar.isSchrikkeljaar()).isTrue();
    }
    @Test
    @DisplayName("Een jaar deelbaar door 100 is geen schrikkeljaar.")
    void eenJaarDeelbaarDoor100IsGeenSchrikkeljaar() {
        assertThat(new Jaar(1900).isSchrikkeljaar()).isFalse();
    }
    @Test
    @DisplayName("Een jaar deelbaar door 4 is een schrikkeljaar.")
    void eenJaarDeelbaarDoor4IsEenSchrikkeljaar() {
        assertThat(new Jaar(2012).isSchrikkeljaar()).isTrue();
    }
    @Test
    @DisplayName("Een jaar niet deelbaar door 4 is geen schrikkeljaar.")
    void eenJaarNietDeelbaarDoor4IsGeenSchrikkeljaar() {
        assertThat(new Jaar(2015).isSchrikkeljaar()).isFalse();
    }
    @Test
    @DisplayName("Method toString() geeft het jaar als tekst terug.")
    void toStringGeeftHetJaarAlsTekst() {
        assertThat(new Jaar(2022)).hasToString("2022");
    }
    @Test
    void jarenMetHetzelfdeJaartalZijnGelijk() {
        assertThat(new Jaar(2015)).isEqualTo(new Jaar(2015));
    }
    @Test
    void jarenMetEenVerschillendJaartalZijnVerschillend() {
        assertThat(new Jaar(2015)).isNotEqualTo(new Jaar(2016));
    }
    @Test
    void deHashCodeVanGelijkeJarenIsGelijk() {
        assertThat(new Jaar(2015)).hasSameHashCodeAs(new Jaar(2015));
    }
}
