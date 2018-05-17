import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ModifyBit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int number = nums[0];
        int position = nums[1];
        int value = nums[2];
        int result = 0;
        switch (value){
            case 0:
                result = number & (~(1 << position));
                break;
            case 1:
                result = number | (1 << position);
                break;
                default:
                    break;
        }
        System.out.println(result);
    }
}
