import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Day2 extends Day {

    public Day2(){
        super("Red-Nosed Reports");
    }

    private class Report{
        private List<Integer> levels;

        public Report(String line){
            levels = convertLineToLevels(line);
        }

        private List<Integer> convertLineToLevels(String line){
            return new ArrayList<>();
        }
    }

    public void partOne(){
        ArrayList<String> lines = SharedMethods.readLines("day2/input_ex.txt");
    }

    public void partTwo(){

    }

}
