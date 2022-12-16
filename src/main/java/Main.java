import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        ReBarDataReader reBarDataReader = new ReBarDataReader();
        ReBarData reBarData;

        if (args.length == 0) {
            reBarData = reBarDataReader.readReBarDataFromTerminal();
        } else {
            reBarData = reBarDataReader.readReBarDataFromFile(args[0]);
        }

        ReBarCalculator reBarCalculator = new ReBarCalculator();
        Map<List<Integer>, Integer> elementsForBarMap = reBarCalculator.calculateReBars(reBarData.getReBarLength(), reBarData.getElementDataList());

        ResultPrinter resultPrinter = new ResultPrinter();
        if (args.length == 2) {
            resultPrinter.printResultToFile(reBarData.getReBarLength(), elementsForBarMap);
        } else {
            resultPrinter.printResultToTerminal(reBarData.getReBarLength(), elementsForBarMap);
        }
    }
}
