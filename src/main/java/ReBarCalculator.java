import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReBarCalculator {

    public void calculateReBars(int reBarLength, List<ElementData> elementDataList) {
        List<Integer> elementsList = new ArrayList<>();
        elementDataList.forEach(elementData -> elementsList.addAll(Collections.nCopies(elementData.getAmount(), elementData.getLength())));

        List<List<Integer>> elementsForBar = new ArrayList<>();
        while (!elementsList.isEmpty()) {
            List<Integer> elementsFromCurrentHinge = new ArrayList<>();

            int n = elementsList.size();
            int W = reBarLength;
            int[][] hingeUtilization = new int[n + 1][W + 1];

            for (int i = 0; i <= n; i++) {
                hingeUtilization[i][0] = 0;
            }

            for (int i = 0; i <= W; i++) {
                hingeUtilization[0][i] = 0;
            }

            for (int i = 1; i <= n; i++) {
                for (int w = 1; w <= W; w++) {
                    hingeUtilization[i][w] = hingeUtilization[i - 1][w];
                    if (elementsList.get(i - 1) <= w) {
                        int val = hingeUtilization[i - 1][w - elementsList.get(i - 1)] + elementsList.get(i - 1);
                        if (val > hingeUtilization[i][w]) {
                            hingeUtilization[i][w] = val;
                        }
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int w = 1; w <= W; w++) {
                    if (hingeUtilization[i][w] < hingeUtilization[i - 1][w]) {
                        System.out.println(i + "   " + w);
                    }
                }
            }

            // trace utilized elements
            int w = W;
            for (int i = n; i > 0; i--) {
                if (elementsList.get(i - 1) <= w && hingeUtilization[i - 1][w - elementsList.get(i - 1)] + elementsList.get(i - 1) > hingeUtilization[i - 1][w]) {
                    elementsFromCurrentHinge.add(elementsList.get(i - 1));
                    w -= elementsList.get(i - 1);
                }
            }

            elementsFromCurrentHinge.forEach(elementsList::remove);
            elementsForBar.add(elementsFromCurrentHinge);
        }

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
}
