package org.example;

import java.util.Scanner;

public class Calculator3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
         //a. It would accept the deposit, interest rate, and number of
        //years from the user.
        // b. It would display the future value and the total interest
        //earned.

        System.out.println("What is your monthly payout?");
        double PMT = scanner.nextDouble();


        System.out.println("What is your expected interest rate?");
        double interestRate = scanner.nextDouble();


        System.out.println("How many years will you keep the annuity?");
        int numYears = scanner.nextInt();

        double r =  interestRate / 12 / 100;

        double n = (numYears * 12);


       //Formula: PV = PMT × [(1 - (1 + r)^(-n)) / r]


        double pV = PMT * ((1 - Math.pow(1 + r, -n)) / r);

        System.out.printf("The present value of your annuity is %.2f. The monthly interest rate of your annuity is %.2f", pV, r);






    }


}
