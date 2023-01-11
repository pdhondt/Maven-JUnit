package be.vdab.theorie.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

public class PersoonRepositoryStub extends PersoonRepository {
    @Override
    public List<BigDecimal> findAllWeddes() {
        return Stream.of(2, 4, 4, 4, 5, 5, 7, 9)
                .map(getal -> BigDecimal.valueOf(getal))
                .toList();
    }
}
