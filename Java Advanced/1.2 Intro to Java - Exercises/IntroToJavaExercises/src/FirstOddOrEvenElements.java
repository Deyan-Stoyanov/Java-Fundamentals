import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FirstOddOrEvenElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] command = reader.readLine().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        switch (command[2]){
            case "even":
                for (int i = 0; i < nums.length; i++) {
                    if(Integer.parseInt(command[1]) <= count){
                        break;
                    }
                    if(nums[i] % 2 == 0){
                        sb.append(nums[i]);
                        sb.append(" ");
                        count++;
                    }
                }
                break;
            case "odd":
                for (int i = 0; i < nums.length; i++) {
                    if(Integer.parseInt(command[1]) <= count){
                        break;
                    }
                    if(nums[i] % 2 != 0){
                        sb.append(nums[i]);
                        sb.append(" ");
                        count++;
                    }
                }
                break;
                default:
                    break;
        }
        System.out.println(sb.toString());
    }
}
