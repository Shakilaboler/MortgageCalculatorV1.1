package org.example;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        // Validate Principal
        int principal;
        while (true) {
            try {
                System.out.print("Principal: ");
                principal = scanner.nextInt();
                if (principal > 0) {
                    break;
                } else {
                    System.out.println("Please enter a principal amount greater than 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer for the principal.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        // Validate Annual Interest Rate
        float annualInterest;
        while (true) {
            try {
                System.out.print("Annual Interest Rate: ");
                annualInterest = scanner.nextFloat();
                if (annualInterest > 0 && annualInterest <= 30) {
                    break;
                } else {
                    System.out.println("Please enter an interest rate between 0 and 30.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for the interest rate.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        // Validate Period in Years
        byte years;
        while (true) {
            try {
                System.out.print("Period Years: ");
                years = scanner.nextByte();
                if (years > 0) {
                    break;
                } else {
                    System.out.println("Please enter a period in years greater than 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for the period.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        scanner.close();

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly Mortgage: " + mortgageFormatted);
    }
}
