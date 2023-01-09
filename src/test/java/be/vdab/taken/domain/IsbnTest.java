package be.vdab.taken.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class IsbnTest {

    @ParameterizedTest
    @ValueSource(longs = { 9789027439642L, 9789057123610L })
    void correcteIsbnNummers(Long nummer) {
        new Isbn(nummer);
    }

    @ParameterizedTest
    @ValueSource(longs = { 9789027439641L, 9789027439643L, 978902743964L, 97890274396425L,
            9779027439642L, 9809027439642L, 0, -9789027439642L })
    void verkeerdeIsbnNummers(Long nummer) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn(nummer)
        );
    }

    @Test
    void toStringGeeftHetIsbnNummerTerugAlsString() {
        assertThat(new Isbn(9789027439642L)).hasToString("9789027439642");
    }
}