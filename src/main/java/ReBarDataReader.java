import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReBarDataReader {

    public ReBarData readReBarDataFromFile(String filename) throws IOException {
        String pathToFile = (filename == null || filename.isEmpty()) ? "src/main/resources/input.txt" : "src/main/resources/" + filename;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathToFile))) {

            int reBarLength = Integer.parseInt(reader.readLine());
            int typesOfFragments = Integer.parseInt(reader.readLine());

            List<ElementData> elementDataList = new ArrayList<>();
            for (int i = 0; i < typesOfFragments; i++) {
                String[] split = reader.readLine().split(" ");

                int length = Integer.parseInt(split[0]);
                int n = Integer.parseInt(split[1]);

                elementDataList.add(new ElementData(length, n));
            }

            return new ReBarData(elementDataList, reBarLength);
        }
    }

    public ReBarData readReBarDataFromTerminal() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter length of re-bar elements are created from: ");
        int L = Integer.parseInt(bufferedReader.readLine());
//        System.out.println(L);

        System.out.println("Enter amount of element types: ");
        int typesOfFragments = Integer.parseInt(bufferedReader.readLine());
//        System.out.println(typesOfFragments);

        List<ElementData> elementDataList = new ArrayList<>();
        for (int i = 0; i < typesOfFragments; i++) {
            System.out.println("Enter length of elements and required amount as {<length> <amount>}:  ");
            String[] split = bufferedReader.readLine().split(" ");

            int length = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);

            elementDataList.add(new ElementData(length, n));
        }

        return new ReBarData(elementDataList, L);
    }
}
