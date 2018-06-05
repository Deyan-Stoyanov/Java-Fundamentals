import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstNumber = trimLeadingZeros(reader.readLine());
        String secondNumber = trimLeadingZeros(reader.readLine());
        int lengthFirst = firstNumber.length();
        int lengthSecond = secondNumber.length();
        StringBuilder sb = new StringBuilder();
        if(lengthFirst > lengthSecond){
            secondNumber = String.format("%" + lengthFirst + "s", secondNumber).replace(' ', '0');
        } else {
            firstNumber = String.format("%" + lengthSecond + "s", firstNumber).replace(' ', '0');
        }
        int remainder = 0;
        for (int j = firstNumber.length() - 1; j >= 0; j--) {
            int tempSum = Integer.parseInt(Character.toString(firstNumber.charAt(j))) +  Integer.parseInt(Character.toString(secondNumber.charAt(j))) + remainder;
            remainder = 0;
            while (tempSum >= 10){
                tempSum -= 10;
                remainder++;
            }
            sb.append(tempSum);
        }
        if(remainder > 0){
            sb.append(remainder);
        }
        String result = sb.reverse().toString();
        System.out.println(result);
    }

    private static String trimLeadingZeros(String number){
        int counter = 0;
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) != '0'){
                break;
            }
            counter++;
        }
        return number.substring(counter);
    }
}
