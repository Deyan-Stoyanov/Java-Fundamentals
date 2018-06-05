import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        char[] arr = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        int state = 0;
        char prev = arr[0];
        for (int i = 0; i < arr.length; i++) {
            switch (state){
                case 0:
                    state = 1;
                    prev = arr[i];
                    break;
                case 1:
                    sb.append(arr[i - 1]);
                    if(arr[i] == prev){
                        state = 2;
                    }
                    prev = arr[i];
                    break;
                case  2:
                    if(arr[i] != prev){
                        state = 1;
                    }
                    prev = arr[i];
                    break;
            }
            ++i;
            if(arr[i - 1] != prev){
                sb.append(prev);
            }
        }
        System.out.println(sb.toString());
    }
}
