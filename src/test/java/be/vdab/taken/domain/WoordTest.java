package be.vdab.taken.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WoordTest {
    @Test
    void legovogelIsEenPalindroom() {
        assertThat(new Woord("legovogel").isPalindroom()).isTrue();
    }
    @Test
    void palindroomIsGeenPalindroom() {
        assertThat(new Woord("palindroom").isPalindroom()).isFalse();
    }
    @Test
    void eenLegeStringIsEenPalindroom() {
        assertThat(new Woord("").isPalindroom()).isTrue();
    }
}
