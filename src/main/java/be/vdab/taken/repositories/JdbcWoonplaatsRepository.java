package be.vdab.taken.repositories;

import be.vdab.taken.exceptions.RepositoryException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcWoonplaatsRepository extends AbstractRepository implements WoonplaatsRepository {
    @Override
    public List<String> findMetStreepjes() {
        try {
            var woonplaatsenMetStreepjes = new ArrayList<String>();
            var sql = """
                    select naam
                    from woonplaatsen
                    where naam like '%-%'
                    """;
            try (var connection = super.getConnection();
                 var statement = connection.prepareStatement(sql)) {
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                connection.setAutoCommit(false);
                var result = statement.executeQuery();
                while (result.next()) {
                    woonplaatsenMetStreepjes.add(result.getString("naam"));
                }
                connection.commit();
                return woonplaatsenMetStreepjes;
            }
        } catch (SQLException ex) {
            throw new RepositoryException(ex);
        }
    }
}
