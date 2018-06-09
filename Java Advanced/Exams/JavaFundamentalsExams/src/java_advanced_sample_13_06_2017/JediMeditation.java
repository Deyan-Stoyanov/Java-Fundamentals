package java_advanced_sample_13_06_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class JediMeditation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> masters = new LinkedList<>();
        Queue<String> knights = new LinkedList<>();
        Queue<String> padawans = new LinkedList<>();
        Queue<String> toshoAndSlav = new LinkedList<>();
        boolean yoda = false;
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            for (String s : input) {
                switch (s.charAt(0)){
                    case 'm':
                        masters.offer(s);
                        break;
                    case 'k':
                        knights.offer(s);
                        break;
                    case 'p':
                        padawans.offer(s);
                        break;
                    case 't':
                    case 's':
                        toshoAndSlav.offer(s);
                        break;
                    case 'y':
                        if(!toshoAndSlav.isEmpty()){
                            yoda = true;
                        }
                        break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(!yoda){

            while (!toshoAndSlav.isEmpty()){
                sb.append(toshoAndSlav.remove()).append(" ");
            }
        }
        while (!masters.isEmpty()){
            sb.append(masters.remove()).append(" ");
        }
        while (!knights.isEmpty()){
            sb.append(knights.remove()).append(" ");
        }
        if(yoda){
            while (!toshoAndSlav.isEmpty()){
                sb.append(toshoAndSlav.remove()).append(" ");
            }
        }
        while (!padawans.isEmpty()){
            sb.append(padawans.remove()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
