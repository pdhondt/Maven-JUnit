package be.vdab.taken;

import be.vdab.taken.exceptions.RepositoryException;
import be.vdab.taken.repositories.JdbcWoonplaatsRepository;
import be.vdab.taken.repositories.TxtWoonplaatsRepository;
import be.vdab.taken.repositories.WoonplaatsRepository;
import be.vdab.taken.services.WoonplaatsService;

import java.util.Scanner;

public class Woonplaats {
    public static void main(String[] args) {
        System.out.print("1=woonplaatsen.txt, 2=database: ");
        var scanner = new Scanner(System.in);
        var keuze = scanner.nextInt();
        while (keuze != 1 && keuze != 2) {
            System.out.print("Verkeerde keuze, probeer opnieuw: ");
            keuze = scanner.nextInt();
        }
        WoonplaatsRepository repository = keuze == 1 ? new TxtWoonplaatsRepository() : new JdbcWoonplaatsRepository();
        try {
            var service = new WoonplaatsService(repository);
            System.out.println("Max aantal streepjes in een woonplaats: " + service.maxAantalStreepjesInEenWoonplaats());
        } catch (RepositoryException ex) {
            System.err.println("Kan woonplaatsen niet lezen.");
            ex.printStackTrace(System.err);
        }
    }
}
