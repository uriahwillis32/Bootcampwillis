package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Mortgage Calculator 1
        //Ask questions concerning data needed from the user.
        // giving customer monthly payment and interest
        //What is your principal (P), interest rate (r), and loan amount(monthly) (n)
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, welcome to our mortgage calculator. " + "Please provide your principal amount:\n");
        double P = scanner.nextDouble();

        System.out.println("Please provide your interest rate in percentage:");
        double interestRate = scanner.nextDouble();

        System.out.println("Please provide your loan length in years:");
        double loanLength = scanner.nextDouble();


        double r =  (interestRate / 100) /12;
        double n = (loanLength * 12);

        //M = P[r(1+r)^n] / [(1+r)^n-1]

        double monthlyPayment = P * (r * Math.pow(1 + r, n) / (Math.pow(1 + r, n) - 1));



        double totalInterest = (monthlyPayment * n) - P;

        System.out.printf("Your Monthly Payment is a total of %.2f. The Total Interest is %.2f.", monthlyPayment, totalInterest);

















    }
}