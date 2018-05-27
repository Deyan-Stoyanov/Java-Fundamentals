import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EncryptSortAndPrintArray {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = reader.readLine();
        }
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            int total = 0;
            char[] charsOfString = strings[i].toCharArray();
            for (char c:charsOfString) {
                if(c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u'){
                    total += (c * strings[i].length());
                } else {
                    total += (c / strings[i].length());
                }
            }
            values[i] = total;
        }

//        for (int i = 0; i < n - 1; i++) {
//            while(values[i] > values[i + 1]){
//                int temp = values[i];
//                values[i] = values[i + 1];
//                values[i + 1] = temp;
//                i = 0;
//            }
//        }

        Arrays.sort(values);
        for (int number:values) {
            System.out.println(number);
        }
    }
}
