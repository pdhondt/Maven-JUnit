package be.vdab.taken.services;

import be.vdab.taken.repositories.WoonplaatsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WoonplaatsServiceTest {
    private WoonplaatsService service;
    @BeforeEach
    void beforeEach() {
        service = new WoonplaatsService(new WoonplaatsRepository());
    }
    @Test
    void maxAantalStreepjesInEenWoonplaatsMagNietNegatiefZijn() {
        assertThat(service.maxAantalStreepjesInEenWoonplaats()).isNotNegative();
    }
}
