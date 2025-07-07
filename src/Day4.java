import java.util.ArrayList;

public class Day4 extends Day {
    protected Day4() {
        super("Ceres Search");
    }

    @Override
    public void partOne() {
        String input = """
__X___
_SAMX_
_A__A_
XMAS_S
_X____
""";

        // 1. convert input string into 2D char array
        String[] lines = input.split("\n");
        int colCount = lines.length;
        int rowCount = 0;
        char[][] rows = new char[colCount][];
        for (int row = 0; row < lines.length; row++) {
            char[] chars = lines[row].toCharArray();
            rowCount = chars.length;
            rows[row] = lines[row].toCharArray();
        }

        // 2. iterate 2d array and start search whenever we encounter an X.
        for(int row = 0; row < rowCount; row++){
            for (int col = 0; col < colCount; col++){
                char currentChar = rows[col][row];

                if (currentChar == 'X'){
                    // 1 Search right

                    // 2 Search left

                    // 3 Search up

                    // 4 Search down

                    // 5 Search diag up right

                    // 6 Search diag up left

                    // 7 Search diag down right

                    // 8 Search diag down left
                }

            }
        }

        // startRow = 0, startCol = 0

        int xmasCount = 0;
        System.out.println(xmasCount);
    }

    @Override
    public void partTwo() {

    }
}
