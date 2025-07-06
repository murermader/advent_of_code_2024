import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Day2 extends Day {

    public Day2() {
        super("Red-Nosed Reports");
    }

    private class Report {
        private Integer[] levels;
        private boolean isSafe = false;

        public Report(String line) {
            levels = convertLineToLevels(line);
        }

        private Integer[] convertLineToLevels(String line) {
            Integer[] levels = Arrays.stream(line.split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);

            Optional<Boolean> isIncreasing = Optional.empty();
            Optional<Integer> previousLevel = Optional.empty();

            for (Integer level: levels){
                if (previousLevel.isPresent()){
                    // Rule 1: Check if the string is constantly increasing or decreasing.
                    if (previousLevel.get().equals(level)){
                        // Neither increasing nor decreasing. We are done!
                        this.isSafe = false;
                        return levels;
                    }
                    boolean isIncreasingFromPreviousLevel = previousLevel.get() < level;
                    if (isIncreasing.isEmpty()){
                        // Initialize value. This value needs to be the same in all coming interations.
                        isIncreasing = Optional.of(isIncreasingFromPreviousLevel);
                    } else {
                        if (!isIncreasing.get().equals(isIncreasingFromPreviousLevel)){
                            // Change detected: Level is not monotonically increasing / decreasing.
                            this.isSafe = false;
                            return levels;
                        }
                    }

                    // Rule 2: Difference at least 1 and at most 3.
                    final int minDifference = 1;
                    final int maxDifference = 3;
                    int diff = Math.abs(previousLevel.get() - level);
                    if (diff < minDifference || diff > maxDifference){
                        this.isSafe = false;
                        return levels;
                    }
                }

                previousLevel = Optional.of(level);
            }

            // Report is safe
            this.isSafe = true;
            return levels;
        }

        public void setIsSafe(boolean isSafe) {
            this.isSafe = isSafe;
        }
    }

    public void partOne() {
        ArrayList<String> lines = SharedMethods.readLines("day2/input.txt");
        List<Report> reports = lines.stream().map(Report::new).toList();
        long safeReportCount = reports.stream().filter(r -> r.isSafe).count();
        System.out.println(safeReportCount);
    }

    public void partTwo() {

    }

}
