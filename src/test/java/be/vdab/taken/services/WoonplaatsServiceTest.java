package be.vdab.taken.services;

import be.vdab.taken.repositories.WoonplaatsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WoonplaatsServiceTest {
    @Mock
    private WoonplaatsRepository repository;
    private WoonplaatsService service;
    @BeforeEach
    void beforeEach() {
        service = new WoonplaatsService(repository);
    }
    @Test
    void eenWoonplaatsBevatMaximaal4Streepjes() {
        when(repository.findMetStreepjes()).thenReturn(
            List.of("Aische-en-Refail", "Annevoie-Rouillon", "Beveren-aan-de-Ijzer", "Nil-Saint-Vincent-Saint-Martin")
        );
        assertThat(service.maxAantalStreepjesInEenWoonplaats()).isEqualTo(4L);
        verify(repository).findMetStreepjes();
    }
}
