package be.vdab.taken.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class IsbnTest {
    @Test
    void isbn9789027439642IsCorrectMetControleGetal2() {
        new Isbn(9789027439642L);
    }
    @Test
    void isbn9789057123610IsCorrectMetControleGetal0() {
        new Isbn(9789057123610L);
    }
    @Test
    void isbn9789027439641HeeftEenVerkeerdControleGetal() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn(9789027439641L)
        );
    }
    @Test
    void isbn9789027439643HeeftEenVerkeerdControleGetal() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn(9789027439643L)
        );
    }
    @Test
    @DisplayName("Een nummer met 12 cijfers is verkeerd")
    void isbn978902743964IsTeKort() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn(978902743964L)
        );
    }
    @Test
    @DisplayName("Een nummer met 14 cijfers is verkeerd")
    void isbn97890274396425IsTeLang() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn(97890274396425L)
        );
    }
    @Test
    void isbn9779027439642EersteDrieCijfersNiet978of979() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn(9779027439642L)
        );
    }
    @Test
    void isbn9809027439642EersteDrieCijfersNiet978of979() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn(9809027439642L)
        );
    }
    @Test
    void nummer0IsVerkeerd() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn(0)
        );
    }
    @Test
    void eenNegatiefNummerIsVerkeerd() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn(-9789027439642L)
        );
    }
    @Test
    void toStringGeeftHetIsbnNummerTerugAlsString() {
        assertThat(new Isbn(9789027439642L)).hasToString("9789027439642");
    }
}