import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day1 extends Day {

    public Day1(){
        super("Historian Hysteria");
    }

    public void partOne() {
        ArrayList<String> lines = readInput();
        Numbers numbers = getNumbers(lines);

        Integer totalDiff = 0;
        for (int i = 0; i < numbers.left().size(); i++) {
            Integer leftSmallest = numbers.left().get(i);
            Integer rightLargest = numbers.right().get(i);
            int diff = Math.abs(leftSmallest - rightLargest);
            totalDiff += diff;
        }

        System.out.println(totalDiff);
    }

    public void partTwo() {
        ArrayList<String> lines = readInput();
        Numbers numbers = getNumbers(lines);
        Map<Integer, Integer> numberOccurences = new HashMap<>();
        for (Integer number : numbers.right()){
            if (numberOccurences.containsKey(number)){
                numberOccurences.put(number, numberOccurences.get(number) + 1);
            } else {
                numberOccurences.put(number, 1);
            }
        }

        Integer total = 0;
        for (Integer leftNumber : numbers.left()){
            if (!numberOccurences.containsKey(leftNumber)){
                continue;
            }
            int numberValue = leftNumber * numberOccurences.get(leftNumber);
            total += numberValue;
        }

        System.out.println(total);
    }

    private ArrayList<String> readInput() {
        return SharedMethods.readLines("day1/input.txt");
    }

    private Numbers getNumbers(List<String> lines){
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
        return new Numbers(leftNumbers, rightNumbers);
    }
}


