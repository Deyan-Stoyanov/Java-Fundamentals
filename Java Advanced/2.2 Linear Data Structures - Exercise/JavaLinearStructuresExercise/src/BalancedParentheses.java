import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = reader.readLine().toCharArray();
        boolean equals = true;
        for (int i = 0; i < input.length / 2; i++) {
            if(!checkEquals(Character.toString(input[i]), Character.toString(input[input.length - 1 - i]))){
                if(!(Character.toString(input[i]).equalsIgnoreCase("(")&&Character.toString(input[i + 1]).equalsIgnoreCase(")"))){
                    equals = false;
                    break;
                }

            }
        }
        if(equals){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    private static Boolean checkEquals(String s, String s1) {
        if((s.equalsIgnoreCase("(") && s1.equalsIgnoreCase(")"))){
            return true;
        }
        if(s.equalsIgnoreCase("[") && s1.equalsIgnoreCase("]")){
            return true;
        }
        if(s.equalsIgnoreCase("{") && s1.equalsIgnoreCase("}")){
            return true;
        }
        return  false;
    }
}
