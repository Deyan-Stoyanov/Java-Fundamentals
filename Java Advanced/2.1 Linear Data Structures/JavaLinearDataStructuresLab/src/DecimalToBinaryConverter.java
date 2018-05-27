import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class DecimalToBinaryConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> binary = new ArrayDeque<>();
        long number = Long.parseLong(reader.readLine());
        if(number == 0){
            binary.push(0);
        }
        while (number != 0){
            binary.push((int)(number % 2));
            number /= 2;
        }
        while (!binary.isEmpty()){
            System.out.print(binary.pop());
        }
    }
}
