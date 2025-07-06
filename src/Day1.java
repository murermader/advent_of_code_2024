import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {

    public void partOne() {
        ArrayList<String> lines = readInput();

        ArrayList<Integer> leftNumbers = new ArrayList<>();
        ArrayList<Integer> rightNumbers = new ArrayList<>();

        for (String line : lines) {
            List<Integer> numbers = Arrays.stream(line.split("\\s+")).map(Integer::parseInt).toList();
            assert numbers.size() == 2;
            Integer left_num = numbers.get(0);
            leftNumbers.add(left_num);
            Integer right_num = numbers.get(1);
            rightNumbers.add(right_num);
        }

        leftNumbers.sort(Integer::compareTo);
        rightNumbers.sort(Integer::compareTo);
        assert leftNumbers.size() == rightNumbers.size();

        Integer totalDiff = 0;
        for (int i = 0; i < leftNumbers.size(); i++) {
            Integer leftSmallest = leftNumbers.get(i);
            Integer rightLargest = rightNumbers.get(i);
            int diff = Math.abs(leftSmallest - rightLargest);
            totalDiff += diff;
        }

        System.out.println("Total difference: " + totalDiff);
    }

    private ArrayList<String> readInput() {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("day1/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return lines;
    }
}
