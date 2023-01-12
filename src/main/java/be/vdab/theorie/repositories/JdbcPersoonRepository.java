package be.vdab.theorie.repositories;

import be.vdab.taken.exceptions.RepositoryException;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersoonRepository extends AbstractRepository implements PersoonRepository {
    @Override
    public List<BigDecimal> findAllWeddes() {
        try {
            var weddes = new ArrayList<BigDecimal>();
            var sql = """
                    select wedde
                    from personen
                    """;
            try (var connection = super.getConnection();
                 var statement = connection.prepareStatement(sql)) {
                for (var result = statement.executeQuery(); result.next(); ) {
                    weddes.add(result.getBigDecimal("wedde"));
                }
            }
            return weddes;
        } catch (SQLException ex) {
            throw new RepositoryException(ex);
        }
    }
}
