package be.vdab.taken.repositories;

import java.util.List;

public class WoonplaatsRepositoryStub extends WoonplaatsRepository {
    @Override
    public List<String> findMetStreepjes() {
        return List.of("Aische-en-Refail", "Annevoie-Rouillon", "Beveren-aan-de-Ijzer", "Nil-Saint-Vincent-Saint-Martin");
    }
}
