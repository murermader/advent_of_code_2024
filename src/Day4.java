import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Day4 extends Day {
    protected Day4() {
        super("Ceres Search");
    }

    @Override
    public void partOne() {
        // 1 down right
        // 2 left
        // 3 right
        // 4 up

        String input;
        input = """
                __X___
                _SAMX_
                _A__A_
                XMAS_S
                _X____
                """;

        try {
            input = Files.readString(Paths.get("day4","input.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int xmasCount = 0;

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
        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rowCount; row++) {
                char currentChar = rows[col][row];

                if (currentChar != 'X') {
                    continue;
                }

                // 1 Search right
                if (checkChar(rows, 'M', col, row + 1)
                        && checkChar(rows, 'A', col, row + 2)
                        && checkChar(rows, 'S', col, row + 3)) {
                    xmasCount++;
                    System.out.printf("Right starting at [%d][%d]\n", col, row);
                }

                // 2 Search left
                if (checkChar(rows, 'M', col, row - 1)
                        && checkChar(rows, 'A', col, row - 2)
                        && checkChar(rows, 'S', col, row - 3)) {
                    xmasCount++;
                    System.out.printf("Left starting at [%d][%d]\n", col, row);
                }

                // 3 Search up
                if (checkChar(rows, 'M', col - 1, row)
                        && checkChar(rows, 'A', col - 2, row)
                        && checkChar(rows, 'S', col - 3, row)) {
                    xmasCount++;
                    System.out.printf("Up starting at [%d][%d]\n", col, row);
                }

                // 4 Search down
                if (checkChar(rows, 'M', col + 1, row)
                        && checkChar(rows, 'A', col + 2, row)
                        && checkChar(rows, 'S', col + 3, row)) {
                    xmasCount++;
                    System.out.printf("Down starting at [%d][%d]\n", col, row);
                }

                // 5 Search diag up right
                if (checkChar(rows, 'M', col - 1, row + 1)
                        && checkChar(rows, 'A', col - 2, row + 2)
                        && checkChar(rows, 'S', col - 3, row + 3)) {
                    xmasCount++;
                    System.out.printf("Up right starting at [%d][%d]\n", col, row);
                }


                // 6 Search diag up left
                if (checkChar(rows, 'M', col - 1, row - 1)
                        && checkChar(rows, 'A', col - 2, row - 2)
                        && checkChar(rows, 'S', col - 3, row - 3)) {
                    xmasCount++;
                    System.out.printf("Up left starting at [%d][%d]\n", col, row);
                }

                // 7 Search diag down right
                if (checkChar(rows, 'M', col + 1, row + 1)
                        && checkChar(rows, 'A', col + 2, row + 2)
                        && checkChar(rows, 'S', col + 3, row + 3)) {
                    xmasCount++;
                    System.out.printf("Down right starting at [%d][%d]\n", col, row);
                }

                // 8 Search diag down left
                if (checkChar(rows, 'M', col + 1, row - 1)
                        && checkChar(rows, 'A', col + 2, row - 2)
                        && checkChar(rows, 'S', col + 3, row - 3)) {
                    xmasCount++;
                    System.out.printf("Down left starting at [%d][%d]\n", col, row);
                }

            }
        }

        System.out.println(xmasCount);
    }

    public boolean checkChar(char[][] arr, char c, int colIndex, int rowIndex) {
        if (colIndex < 0 || rowIndex < 0) {
            return false;
        }
        if (colIndex >= arr.length) {
            return false;
        }

        char[] row = arr[colIndex];
        if (rowIndex >= row.length) {
            return false;
        }
        return row[rowIndex] == c;
    }

    @Override
    public void partTwo() {

    }
}
