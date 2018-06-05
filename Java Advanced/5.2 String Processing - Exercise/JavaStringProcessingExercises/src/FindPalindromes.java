import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class FindPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] text = reader.readLine().split("[\\s,.!?]+");
        Set<String> palindromes = new TreeSet<>();
        for (String s : text) {
            if(checkPalindrome(s)){
                palindromes.add(s);
            }
        }
        System.out.println(palindromes.toString());
    }

    private static boolean checkPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < (chars.length / 2) + (chars.length % 2); i++) {
            if(chars[i] != chars[chars.length - i - 1]){
                return false;
            }
        }
        return true;
    }
}
