package be.vdab.theorie.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class RekeningNummerTest {
    @Test
    void BE72091012240116IsCorrect() {
        new RekeningNummer("BE72091012240116");
    }
    @Test
    void BE68539007547034IsCorrect() {
        new RekeningNummer("BE68539007547034");
    }
    @Test
    void BE02063588295840IsCorrect() {
        new RekeningNummer("BE02063588295840"); // controlegetal < 10
    }
    @Test
    void BE720910122401160IsTeLang() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RekeningNummer("BE720910122401160")
        );
    }
    @Test
    void BE7209101224011IsTeKort() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RekeningNummer("BE7209101224011")
        );
    }
    @Test
    void NL72091012240116IsVerkeerdWegensNietBelgisch() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RekeningNummer("NL72091012240116")
        );
    }
    @Test
    void BEX209101224011YBevatVerkeerdeTekens() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RekeningNummer("BEX209101224011Y")
        );
    }
    @Test
    void BE01091012240116BevatEenTeKleinControleGetal() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RekeningNummer("BE01091012240116")
        );
    }
    @Test
    void BE99091012240116BevatEenTeGrootControleGetal() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RekeningNummer("BE99091012240116")
        );
    }
    @Test
    void BE72091012240115BevatEenVerkeerdeControleBerekening() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RekeningNummer("BE72091012240115")
        );
    }
    @Test
    void nummerMetNullIsVerkeerd() {
        assertThatNullPointerException().isThrownBy(
                () -> new RekeningNummer(null)
        );
    }
    @Test
    void leegNummerIsVerkeerd() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RekeningNummer("")
        );
    }
    @Test
    void toStringGeeftHetNummerTerug() {
        var nummer = "BE72091012240116";
        assertThat(new RekeningNummer(nummer)).hasToString(nummer);
    }
}