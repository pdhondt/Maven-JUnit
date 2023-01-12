package be.vdab.theorie;

import be.vdab.theorie.exceptions.RepositoryException;
import be.vdab.theorie.repositories.CsvPersoonRepository;
import be.vdab.theorie.repositories.JdbcPersoonRepository;
import be.vdab.theorie.repositories.PersoonRepository;
import be.vdab.theorie.services.PersoonService;

import java.util.Scanner;

public class StandaardAfwijking {
    public static void main(String[] args) {
        System.out.print("1=weddes.csv, 2=database:");
        var scanner = new Scanner(System.in);
        var keuze = scanner.nextInt();
        while (keuze != 1 && keuze != 2) {
            System.out.print("Verkeerde keuze, probeer opnieuw:");
            keuze = scanner.nextInt();
        }
        PersoonRepository repository = keuze == 1 ? new CsvPersoonRepository() : new JdbcPersoonRepository();
        try {
            var service = new PersoonService(repository);
            System.out.println(service.standaardAfwijkingWeddes());
        } catch (RepositoryException ex) {
            System.err.println("Kan personen niet lezen.");
            ex.printStackTrace(System.err);
        }
    }
}
