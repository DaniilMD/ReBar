import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultPrinter {

    public void printResultToTerminal(int reBarLength, Map<List<Integer>, Integer> elementsForBarMap) {
        Set<Map.Entry<List<Integer>, Integer>> entries = elementsForBarMap.entrySet();

        int hingesAmount = entries.size();
        System.out.println("Required amount of re-bars: [" + hingesAmount + "]\n");

        for (Map.Entry<List<Integer>, Integer> entry : entries) {
            List<Integer> elementsCombination = entry.getKey();
            System.out.println(
                    "Layout: " + elementsCombination
                            + " Amount of layout utilization: [" + elementsForBarMap.get(elementsCombination) + "]"

                            + " Utilized length: " + elementsCombination.stream().reduce(0, Integer::sum)
                            + "/"
                            + reBarLength

                            + " Unused length: " + (reBarLength - elementsCombination.stream().reduce(0, Integer::sum))
                            + "/"
                            + reBarLength

                            + "\n"
            );
        }
    }

    public void printResultToFile(int reBarLength, Map<List<Integer>, Integer> elementsForBarMap) throws IOException {
        Set<Map.Entry<List<Integer>, Integer>> entries = elementsForBarMap.entrySet();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/output.txt"))) {
            int hingesAmount = entries.size();
            writer.write("Required amount of re-bars: [" + hingesAmount + "]\n\n");

            for (Map.Entry<List<Integer>, Integer> entry : entries) {
                List<Integer> elementsCombination = entry.getKey();
                writer.write(
                        "Layout: " + elementsCombination
                                + " Amount of layout utilization: [" + elementsForBarMap.get(elementsCombination) + "]"

                                + " Utilized length: " + elementsCombination.stream().reduce(0, Integer::sum)
                                + "/"
                                + reBarLength

                                + " Unused length: " + (reBarLength - elementsCombination.stream().reduce(0, Integer::sum))
                                + "/"
                                + reBarLength

                                + "\n\n"
                );
            }

        }

    }
}
