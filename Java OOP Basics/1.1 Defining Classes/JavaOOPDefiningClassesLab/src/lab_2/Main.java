package lab_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, lab_2.BankAccount> accounts = new LinkedHashMap<>();
        String line;
        while (!"End".equalsIgnoreCase(line = reader.readLine())) {
            String[] input = line.split(" ");
            switch (input[0]) {
                case "Create":
                    lab_2.BankAccount bankAccount = new lab_2.BankAccount();
                    accounts.put(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    int depositAccountId = Integer.parseInt(input[1]);
                    double depositAmount = Double.parseDouble(input[2]);
                    if(accounts.containsKey(depositAccountId)){
                        accounts.get(depositAccountId).deposit(depositAmount);
                        System.out.printf("Deposited %.0f to ID%d%n", depositAmount, depositAccountId);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(input[1]);
                    lab_2.BankAccount.setInterestRate(interestRate);
                    break;
                case "GetInterest":
                    int getInterestId = Integer.parseInt(input[1]);
                    int years = Integer.parseInt(input[2]);
                    if(accounts.containsKey(getInterestId)){
                        System.out.printf("%.2f%n", accounts.get(getInterestId).getInterestRate(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
