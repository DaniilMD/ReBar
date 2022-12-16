import java.io.IOException;
import java.util.List;

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
        List<List<Integer>> elementsForBar = reBarCalculator.calculateReBars(reBarData.getReBarLength(), reBarData.getElementDataList());

        ResultPrinter resultPrinter = new ResultPrinter();
        if (args.length == 2) {
            resultPrinter.printResultToFile(reBarData.getReBarLength(), elementsForBar);
        } else {
            resultPrinter.printResultToTerminal(reBarData.getReBarLength(), elementsForBar);
        }
    }
}
