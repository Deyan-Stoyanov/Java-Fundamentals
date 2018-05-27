import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> firstPlayer = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(HashSet::new));
        Set<Integer> secondPlayer = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(HashSet::new));
        for (int i = 0; i < 50; i++) {
            if(firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;
            }
            int firstNum = firstPlayer.iterator().next();
            firstPlayer.remove(firstNum);
            int secondNum = secondPlayer.iterator().next();
            secondPlayer.remove(secondNum);
            if(firstNum > secondNum){
                firstPlayer.add(firstNum);
                firstPlayer.add(secondNum);
            } else if (secondNum > firstNum){
                secondPlayer.add(firstNum);
                secondPlayer.add(secondNum);
            }
        }
        if(firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");
        } else if(secondPlayer.size() > firstPlayer.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
