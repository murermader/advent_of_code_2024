import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 extends Day {
    protected Day3() {
        super("Mull It Over");
    }

    @Override
    public void partOne() {
        String content;
//        content = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";

        try {
            content = Files.readString(Paths.get("day3","input.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(content);

        int total = 0;
        while(matcher.find()){
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            total += Integer.parseInt(group1) * Integer.parseInt(group2);
        }

        System.out.println(total);
    }

    @Override
    public void partTwo() {
        String content;
        content = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";

        try {
            content = Files.readString(Paths.get("day3","input.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Pattern pattern = Pattern.compile("(?:mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\))");
        Matcher matcher = pattern.matcher(content);

        int total = 0;
        boolean isMulEnabled = true;
        while(matcher.find()){
            if (matcher.group(0).equals("do()")){
                isMulEnabled = true;
            }
            if (matcher.group(0).equals("don't()")){
                isMulEnabled = false;
            }

            if (matcher.group(0).startsWith("mul") && isMulEnabled){
                String group1 = matcher.group(1);
                String group2 = matcher.group(2);
                total += Integer.parseInt(group1) * Integer.parseInt(group2);
            }
        }

        System.out.println(total);
    }
}
