package lab_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BankAccount acc = new BankAccount();
        acc.setId(1);
        acc.setBalance(15);
        System.out.printf("Account ID%d, balance %.2f%n", acc.getId(), acc.getBalance());

        Map<Integer, BankAccount> accounts = new LinkedHashMap<>();
        String line;
        while (!"End".equalsIgnoreCase(line = reader.readLine())) {
            String[] input = line.split(" ");
            int accountId = Integer.parseInt(input[1]);
            switch (input[0]) {
                case "Create":
                    if (accounts.containsKey(accountId)) {
                        System.out.println("Account already exists");
                    } else {
                        BankAccount bankAccount = new BankAccount();
                        bankAccount.setId(accountId);
                        accounts.put(accountId, bankAccount);
                    }
                    break;
                case "Deposit":
                    double depositAmount = Double.parseDouble(input[2]);
                    if (accounts.containsKey(accountId)) {
                        accounts.get(accountId).deposit(depositAmount);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "Withdraw":
                    double withdrawAmount = Double.parseDouble(input[2]);
                    if (accounts.containsKey(accountId)) {
                        try {
                            accounts.get(accountId).withdraw(withdrawAmount);
                        } catch (IllegalArgumentException ie) {
                            System.out.println(ie.getMessage());
                        }
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "Print":
                    if (accounts.containsKey(accountId)) {
                        System.out.println(accounts.get(accountId).toString());
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
