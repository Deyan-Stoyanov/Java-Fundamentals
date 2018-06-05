import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {

    private static final String INPUT_PATH = "E:\\Java Fundamentals\\Java Advanced\\7.2 Built-in Query methods - Stream API - Exercises\\WorkingWIthMSExcel\\src\\main\\resources\\StudentData.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_PATH)))){
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("StudentData");
            Map<String, Object[]> data = new TreeMap<>();
            String firstLine = reader.readLine();
            int n = 1;
            String[] firstLineElements = firstLine.split("[\\t]+");
            Object[] firstObject = new Object[] {firstLineElements[0], firstLineElements[1], firstLineElements[2], firstLineElements[3], firstLineElements[4], firstLineElements[5], firstLineElements[6], firstLineElements[7], firstLineElements[8], firstLineElements[9], firstLineElements[10]};
            data.put(Integer.toString(n), firstObject);
            String line;
            while(null != (line = reader.readLine())) {
                n++;
                String[] input = line.split("[\\t]+");
                String facultyNumber = input[0];
                String firstName  = input[1];
                String lastName = input[2];
                String email = input[3];
                Integer age = Integer.parseInt(input[4]);
                Integer group = Integer.parseInt(input[5]);
                Integer firstGrade = Integer.parseInt(input[6]);
                Integer secondGrade = Integer.parseInt(input[7]);
                Integer thirdGrade = Integer.parseInt(input[8]);
                Integer fourthGrade = Integer.parseInt(input[9]);
                String phoneNumber  = input[10];
                Object[] student = new Object[] {facultyNumber, firstName, lastName, email, age, group, firstGrade, secondGrade, thirdGrade, fourthGrade, phoneNumber};
                data.put(Integer.toString(n), student);
            }
            System.out.println("File read");
            Set<String> keySet = data.keySet();
            int rowNumber = 0;
            for (String key : keySet)
            {
                Row row = sheet.createRow(rowNumber++);
                Object[] objArr = data.get(key);
                int cellNumber = 0;
                for (Object obj : objArr)
                {
                    Cell cell = row.createCell(cellNumber++);
                    if(obj instanceof String)
                        cell.setCellValue((String)obj);
                    else if(obj instanceof Integer)
                        cell.setCellValue((Integer)obj);
                }
            }
            FileOutputStream out = new FileOutputStream(new File("output.xlsx"));
            workbook.write(out);
            System.out.println("File written");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
