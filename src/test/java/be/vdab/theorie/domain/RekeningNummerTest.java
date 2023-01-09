package be.vdab.theorie.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class RekeningNummerTest {

    @ParameterizedTest
    @ValueSource(strings = { "BE72091012240116", "BE68539007547034", "BE02063588295840" })
    void correcteNummers(String nummer) {
        new RekeningNummer(nummer);
    }

    @ParameterizedTest
    @ValueSource(strings = { "BE720910122401160", "BE7209101224011", "NL72091012240116",
            "BEX209101224011Y", "BE01091012240116", "BE99091012240116",
            "BE72091012240115", "" })
    void verkeerdeNummers(String nummer) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RekeningNummer(nummer)
        );
    }

    @Test
    void nummerMetNullIsVerkeerd() {
        assertThatNullPointerException().isThrownBy(
                () -> new RekeningNummer(null)
        );
    }

    @Test
    void toStringGeeftHetNummerTerug() {
        var nummer = "BE72091012240116";
        assertThat(new RekeningNummer(nummer)).hasToString(nummer);
    }
}