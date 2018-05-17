import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransportPrice {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long kilometers = Long.parseLong(reader.readLine());
        String time = reader.readLine();
        double price = 0;
        switch (time.toLowerCase()){
            case "day":
                if(kilometers >= 100){
                    price = 0.06 * kilometers;
                } else if(kilometers >= 20) {
                    price = 0.09 * kilometers;
                } else{
                    price = 0.70 + (0.79 * kilometers);
                }
                break;
            case "night":
                if(kilometers >= 100){
                    price = 0.06 * kilometers;
                } else if(kilometers >= 20) {
                    price = 0.09 * kilometers;
                } else{
                    price = 0.70 + (0.90 * kilometers);
                }
                break;
                default:
                    break;
        }
        System.out.printf("%.2f", price);
    }
}
