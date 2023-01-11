package be.vdab.taken.repositories;

import be.vdab.taken.exceptions.RepositoryException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WoonplaatsRepository {
    public List<String> findMetStreepjes() {
        try (var stream = Files.lines(Path.of("/Users/dhond/Documents/Coding/VDAB/Java Ontwikkelaar/JUnit/JUnitMateriaal/woonplaatsen.txt"))) {
            return stream
                    .filter(woonplaats -> woonplaats.contains("-"))
                    .toList();
        } catch (IOException ex) {
            throw new RepositoryException(ex);
        }
    }
}
