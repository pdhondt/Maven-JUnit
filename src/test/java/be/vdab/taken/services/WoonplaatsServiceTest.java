package be.vdab.taken.services;

import be.vdab.taken.repositories.WoonplaatsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WoonplaatsServiceTest {
    private WoonplaatsService service;
    @BeforeEach
    void beforeEach() {
        service = new WoonplaatsService(new WoonplaatsRepositoryStub());
    }
    @Test
    void eenWoonplaatsBevatMaximaal4Streepjes() {
        assertThat(service.maxAantalStreepjesInEenWoonplaats()).isEqualTo(4L);
    }
}
