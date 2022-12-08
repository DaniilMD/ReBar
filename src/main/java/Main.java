import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter length of re-bar elements are created from: ");
        int L = Integer.parseInt(bufferedReader.readLine());
//        System.out.println(L);

        System.out.println("Enter amount of element types: ");
        int typesOfFragments = Integer.parseInt(bufferedReader.readLine());
//        System.out.println(typesOfFragments);


        List<ElementData> elementDataList = new ArrayList<>();


//        List<Integer> elementsList = new ArrayList<>();
        for (int i = 0; i < typesOfFragments; i++) {
            System.out.println("Enter length of elements and required amount as {<length> <amount>}:  ");
            String[] split = bufferedReader.readLine().split(" ");

            int length = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);


            elementDataList.add(new ElementData(length, n));

//            elementsList.addAll(Collections.nCopies(n, length));
        }
//        System.out.println(elementsList);


//        elementDataList.forEach(elementData -> elementsList.addAll(Collections.nCopies(elementData.getAmount(), elementData.getLength())));

        ReBarCalculator reBarCalculator = new ReBarCalculator();

        reBarCalculator.calculateReBars(L, elementDataList);


//
//        List<List<Integer>> elementsForBar = new ArrayList<>();
//        while (!elementsList.isEmpty()) {
//            List<Integer> elementsFromCurrentHinge = new ArrayList<>();
//
//            int n = elementsList.size();
//            int W = L;
//            int[][] hingeUtilization = new int[n + 1][W + 1];
//
//            for (int i = 0; i <= n; i++) {
//                hingeUtilization[i][0] = 0;
//            }
//
//            for (int i = 0; i <= W; i++) {
//                hingeUtilization[0][i] = 0;
//            }
//
//            for (int i = 1; i <= n; i++) {
//                for (int w = 1; w <= W; w++) {
//                    hingeUtilization[i][w] = hingeUtilization[i - 1][w];
//                    if (elementsList.get(i - 1) <= w) {
//                        int val = hingeUtilization[i - 1][w - elementsList.get(i - 1)] + elementsList.get(i - 1);
//                        if (val > hingeUtilization[i][w]) {
//                            hingeUtilization[i][w] = val;
//                        }
//                    }
//                }
//            }
//
//            for (int i = 1; i <= n; i++) {
//                for (int w = 1; w <= W; w++) {
//                    if (hingeUtilization[i][w] < hingeUtilization[i - 1][w]) {
//                        System.out.println(i + "   " + w);
//                    }
//                }
//            }
//
//            // trace utilized elements
//            int w = W;
//            for (int i = n; i > 0; i--) {
//                if (elementsList.get(i - 1) <= w && hingeUtilization[i - 1][w - elementsList.get(i - 1)] + elementsList.get(i - 1) > hingeUtilization[i - 1][w]) {
//                    elementsFromCurrentHinge.add(elementsList.get(i - 1));
//                    w -= elementsList.get(i - 1);
//                }
//            }
//
//            elementsFromCurrentHinge.forEach(elementsList::remove);
//            elementsForBar.add(elementsFromCurrentHinge);
//        }
//
//        int hingesAmount = elementsForBar.size();
//        System.out.println("\nRequired amount of re-bars: [" + hingesAmount + "]\n");
//
//        for (List<Integer> integers : elementsForBar) {
//            System.out.println(integers
//                    + "  Utilized length: "
//                    + integers.stream().reduce(0, Integer::sum)
//                    + "/"
//                    + L
//            );
//        }
//
    }
}




/*
11700
3
3380 84
4365 26
3400 36
*/


/*
11700
3
3380 1
4365 1
3400 2
*/


/*
45
4
30 1
14 1
16 1
9 1
*/


/*
11700
4
5000 23
4875 12
6957 11
1112 7
*/


/*
11
2
7 1
2 1
*/


/*
117
4
50 23
48 12
69 11
11 7
*/

