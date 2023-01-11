package be.vdab.taken.services;

import be.vdab.taken.repositories.WoonplaatsRepository;
import org.apache.commons.lang3.StringUtils;

public class WoonplaatsService {
    private final WoonplaatsRepository repository;
    public WoonplaatsService(WoonplaatsRepository repository) {
        this.repository = repository;
    }
    public long maxAantalStreepjesInEenWoonplaats() {
        var woonplaatsenMetStreepjes = repository.findMetStreepjes();
        var maxAantalStreepjes = 0;
        for (var plaats : woonplaatsenMetStreepjes) {
            int teller = StringUtils.countMatches(plaats, "-");
            maxAantalStreepjes = teller > maxAantalStreepjes ? teller : maxAantalStreepjes;
        }
        return maxAantalStreepjes;
    }
}
