import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiConsumer;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        BiConsumer<int[], String> changeNumber = (num, str) -> {
                switch (str){
                    case "add":
                        for (int i = 0; i < num.length; i++) {
                            ++num[i];
                        }
                        break;
                    case "multiply":
                        for (int i = 0; i < num.length; i++) {
                            num[i] *= 2;
                        }
                        break;
                    case "subtract":
                        for (int i = 0; i < num.length; i++) {
                            --num[i];
                        }
                        break;
                    case "print":
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < num.length; i++) {
                            stringBuilder.append(num[i]).append(" ");
                        }
                        System.out.println(stringBuilder);
                }
        };
        String command;
        while(!"end".equalsIgnoreCase(command = reader.readLine())) {
            changeNumber.accept(nums, command);
        }
    }
}
