package be.vdab.taken;

import be.vdab.taken.exceptions.RepositoryException;
import be.vdab.taken.repositories.WoonplaatsRepository;
import be.vdab.taken.services.WoonplaatsService;

public class Woonplaats {
    public static void main(String[] args) {
        try {
            var service = new WoonplaatsService(new WoonplaatsRepository());
            System.out.println("Max aantal streepjes in een woonplaats: " + service.maxAantalStreepjesInEenWoonplaats());
        } catch (RepositoryException ex) {
            System.err.println("Kan woonplaatsen niet lezen.");
            ex.printStackTrace(System.err);
        }
    }
}
