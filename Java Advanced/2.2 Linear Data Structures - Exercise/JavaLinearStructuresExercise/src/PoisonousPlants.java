import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> plants = new ArrayList<>();
        for (int a:input) {
            plants.add(a);
        }
        int days = 0;
        while(true){
            boolean allOk = true;
            ArrayList<Integer> plantsToStay = new ArrayList<>();
            plantsToStay.add(plants.get(0));
            for (int i = 1; i < plants.size(); i++) {
                if(plants.get(i)>plants.get(i - 1)){
                    allOk = false;
                }else {
                    plantsToStay.add(plants.get(i));
                }
            }
            if(allOk){
                break;
            }
            plants.clear();
            plants.addAll(plantsToStay);
            String d;
            days++;
        }
        System.out.println(days);

    }
}
