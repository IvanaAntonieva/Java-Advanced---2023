package Lab_03_BankAccount;

import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> accounts = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (input.equals("Create")) {
                BankAccount currentAccount = new BankAccount();
                int id = currentAccount.getId();
                accounts.put(id, currentAccount);
                System.out.printf("Account ID%d created%n", id);
            } else if (input.contains("Deposit")) {
                String[] commandData = input.split("\\s+");
                int id = Integer.parseInt(commandData[1]);
                double amount = Double.parseDouble(commandData[2]);
                if (accounts.containsKey(id)) {
                    accounts.get(id).deposit(amount);
                    System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (input.contains("SetInterest")) {
                String[] commandData = input.split("\\s+");
                double interest = Double.parseDouble(commandData[1]);
                BankAccount.setInterestRate(interest);
            } else if (input.contains("GetInterest")) {
                String[] commandData = input.split("\\s+");
                int id = Integer.parseInt(commandData[1]);
                int years = Integer.parseInt(commandData[2]);
                if (accounts.containsKey(id)) {
                    double interest = accounts.get(id).getInterest(years);
                    System.out.printf("%.2f%n", interest);
                } else {
                    System.out.println("Account does not exist");
                }
            }
            input = scanner.nextLine();
        }
    }
}
