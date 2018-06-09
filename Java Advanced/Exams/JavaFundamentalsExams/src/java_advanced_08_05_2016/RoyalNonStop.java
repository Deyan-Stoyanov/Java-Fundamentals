package java_advanced_08_05_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class RoyalNonStop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dimensions = reader.readLine();
        String[] prices = reader.readLine().split(" ");
        BigDecimal lukanka = new BigDecimal(prices[0]);
        BigDecimal rakija = new BigDecimal(prices[1]);
        BigDecimal total = BigDecimal.ZERO;
        int customerCount = 0;
        String command;
        while (!"Royal Close".equalsIgnoreCase(command = reader.readLine())) {
            String[] indexes = command.split(" ");
            int row = Integer.parseInt(indexes[0]);
            int col = Integer.parseInt(indexes[1]);
            BigDecimal tempSum = BigDecimal.ZERO;
            if (row >= col) {
                for (int j = col; j >= 0; j--) {
                    if (row % 2 == 0) {
                        tempSum = tempSum.add(lukanka.multiply(BigDecimal.valueOf((row + 1) * (j + 1))));
                    } else {
                        tempSum = tempSum.add(rakija.multiply(BigDecimal.valueOf((row + 1) * (j + 1))));
                    }
                }
                for (int j = row - 1; j >= 1; j--) {
                    if (j % 2 == 0) {
                        tempSum = tempSum.add(lukanka.multiply(BigDecimal.valueOf(j + 1)));

                    } else {
                        tempSum = tempSum.add(rakija.multiply(BigDecimal.valueOf(j + 1)));

                    }
                }

            } else {
                for (int j = row; j >= 0; j--) {
                    if (j % 2 == 0) {
                        tempSum = tempSum.add(lukanka.multiply(BigDecimal.valueOf((col + 1) * (j + 1))));

                    } else {
                        tempSum = tempSum.add(rakija.multiply(BigDecimal.valueOf((col + 1) * (j + 1))));

                    }
                }
                for (int j = col - 1; j >= 1; j--) {
                    tempSum = tempSum.add(lukanka.multiply(BigDecimal.valueOf(j + 1)));
                }
            }
            total = total.add(tempSum);
            customerCount++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.6f", total)).

                append(System.lineSeparator());
        sb.append(customerCount);
        System.out.println(sb.toString());
    }
}
