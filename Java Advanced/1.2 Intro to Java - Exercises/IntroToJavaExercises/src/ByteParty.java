import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ByteParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = (Integer.parseInt(reader.readLine()));
        }
        String line = reader.readLine();
        while(true){
            if("party over".equals(line)){
                break;
            }
            int[] commands = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int position = commands[1];
            switch (commands[0]){
                case -1:
                    for (int i = 0; i < numbers.length; i++) {
                        if(((numbers[i] >> position) & 1) == 0){
                            numbers[i] = (numbers[i] | (1 << position));
                        }else {
                            numbers[i] = (numbers[i] & (~(1 << position)));
                        }
                    }
                    break;
                case 0:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = (numbers[i] & (~(1 << position)));
                    }
                    break;
                case 1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = (numbers[i] | (1 << position));
                    }
                    break;
                    default:
                        break;
            }
            line = reader.readLine();
        }
        for (int number :numbers) {
            System.out.println(number);
        }
    }
}
