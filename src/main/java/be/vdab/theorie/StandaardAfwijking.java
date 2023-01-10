package be.vdab.theorie;

import be.vdab.theorie.exceptions.RepositoryException;
import be.vdab.theorie.repositories.PersoonRepository;
import be.vdab.theorie.services.PersoonService;

public class StandaardAfwijking {
    public static void main(String[] args) {
        try {
            var service = new PersoonService(new PersoonRepository());
            System.out.println(service.standaardAfwijkingWeddes());
        } catch (RepositoryException ex) {
            System.err.println("Kan personen niet lezen.");
            ex.printStackTrace(System.err);
        }
    }
}
