import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultPrinter {

    public void printResultToTerminal(int reBarLength, List<List<Integer>> elementsForBar) {
        int hingesAmount = elementsForBar.size();
        System.out.println("\nRequired amount of re-bars: [" + hingesAmount + "]\n");

        for (List<Integer> integers : elementsForBar) {
            System.out.println(integers
                    + "  Utilized length: "
                    + integers.stream().reduce(0, Integer::sum)
                    + "/"
                    + reBarLength
            );
        }
    }

    public void printResultToFile(int reBarLength, List<List<Integer>> elementsForBar) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/output.txt"))) {

            int hingesAmount = elementsForBar.size();
            writer.write("Required amount of re-bars: [" + hingesAmount + "]\n\n");

            for (List<Integer> integers : elementsForBar) {
                writer.write(integers
                        + "  Utilized length: "
                        + integers.stream().reduce(0, Integer::sum)
                        + "/"
                        + reBarLength
                        + "\n"
                );
            }

        }

    }
}
