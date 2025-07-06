import java.util.ArrayList;
import java.util.List;

public class AdventOfCode {
    public static void main(String[] args) {
        Day[] days = {
                new Day1(),
                new Day2()
        };

        for (Day day : days){
            System.out.printf("Executing day: %s\n", day.getName());
            day.execute();
            System.out.println();
        }
    }
}