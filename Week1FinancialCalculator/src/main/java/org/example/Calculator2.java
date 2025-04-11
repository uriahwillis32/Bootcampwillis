package org.example;

import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your deposit amount: ");
        double P = scanner.nextDouble();

        System.out.println("What is your interest rate in percentage: ");
        double interestRate = scanner.nextDouble();
       ;

        System.out.println("What is the number of years you will hold the cd: ");
        int t = scanner.nextInt();

        int n = 365;//number of times interest is compounded per year.

        double r =  (interestRate / 100) / n;


        //FV = P * (1 +(r / 365))^(365 * t)

        double part1 = P * (1 + r/n);
        double fV = P * Math.pow(1 + r/n, n * t);

        double totalInterest = fV - P;

        System.out.printf("Your Final Value is a total of %.2f. The Total Interest is %2f..", fV, totalInterest);




    }
}
