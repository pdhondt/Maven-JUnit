package be.vdab.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class PersonenCSVMaker {
    private final static String[] VOORNAMEN =
            { "Arthur", "Noa", "Adam", "Louis", "Liam", "Emma", "Olivia", "Louise",
                    "Mila", "Alice" };
    private final static String[] FAMILIENAMEN =
            { "Peeters", "Janssens", "Maes", "Jacobs", "Mertens", "Willems", "Claes",
                    "Goossens", "Wouters", "Desmet" };
    private final static Path BESTAND_PATH = Path.of("/data/personen.csv");
    private final static Path DIRECTORY_PATH = BESTAND_PATH.getParent();

    public static void main(String[] args) throws IOException {
        if (!Files.isDirectory(DIRECTORY_PATH)) {
            Files.createDirectory(DIRECTORY_PATH);
        }
        var random = new Random();
        try (var writer = Files.newBufferedWriter(BESTAND_PATH)) {
            for (var i = 1; i <= 10_000_000; i++) {
                writer.write(String.valueOf(i));
                writer.write(',');
                writer.write(VOORNAMEN[random.nextInt(VOORNAMEN.length)]);
                writer.write(',');
                writer.write(FAMILIENAMEN[random.nextInt(FAMILIENAMEN.length)]);
                writer.write(',');
                writer.write(String.valueOf(2000 + random.nextInt(3000)));
                writer.write('.');
                writer.write(String.valueOf(random.nextInt(100)));
                writer.newLine();
                System.out.println(String.format("%,d", i));
            }
        }
        System.out.println("Bestand gemaakt");
    }
}
