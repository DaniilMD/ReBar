import java.io.IOException;

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
        reBarCalculator.calculateReBars(reBarData.getReBarLength(), reBarData.getElementDataList());
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

