import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");
        BiPredicate<String, Integer> isNameCorrect = (name, num) -> {
            if(name.length() <= n){
                return true;
            }
            return false;
        };
        for (String name : names) {
            if(isNameCorrect.test(name, n)){
                System.out.println(name);
            }
        }
    }
}
