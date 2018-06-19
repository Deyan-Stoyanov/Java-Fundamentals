package box_validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Box box = null;
        try{
            box = new Box(Double.parseDouble(reader.readLine()), Double.parseDouble(reader.readLine()), Double.parseDouble(reader.readLine()));
        }catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
        }
        if(box != null){
            System.out.println(box);
        }
    }
}
