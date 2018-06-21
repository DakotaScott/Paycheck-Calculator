package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Keyboard input initialization
        Scanner keyboard = new Scanner(System.in);

        BigDecimal schoolDistricTaxRate = new BigDecimal("0.00");
        BigDecimal federalTaxRate = new BigDecimal("0.00");
        BigDecimal localTaxRate = new BigDecimal("0.00");
        BigDecimal MEDICARE_TAX_RATE = new BigDecimal("0.0145");
        BigDecimal stateTax = new BigDecimal("0.00");

        BigDecimal grossEarnings;
        BigDecimal wagesPerHour;
        BigDecimal federalTaxWithheld;
        BigDecimal netEarnings = new BigDecimal("0.00");
        BigDecimal hoursWorked;

        System.out.println("PAYCHECK CALCULATOR");
        System.out.println("WARNING: CALCULATIONS ONLY APPLY TO BIWEEKLY PAY PERIODS");
        System.out.println("Proceed? (Y/N)");

        // Calls checkStatus method to collect user input to proceed
        checkStatus();

        System.out.println("Enter your hourly wage amount: ");
        wagesPerHour = keyboard.nextBigDecimal();
        System.out.println("Enter your hours worked: ");
        hoursWorked = keyboard.nextBigDecimal();

        grossEarnings = wagesPerHour.multiply(hoursWorked);

        // Currency formatter
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("$" + df.format(grossEarnings));

        federalTaxWithheld = singleBiweeklyWithholdingRate(grossEarnings);

        System.out.println("$" + federalTaxWithheld);
    }

    public static char checkStatus()
    {
        // Keyboard input initialization
        Scanner keyboard = new Scanner(System.in);

        char choice = '\0';
        choice = keyboard.next().charAt(0);

        // Checks for user choice and calls the method again if a choice is done in error
        if (choice == ('n'|'N')) {
            System.exit(0);
        } else if (choice == ('y'|'Y')){
            return choice;
        } else {
            System.out.println("Unrecognizable input.");
            System.out.println("WARNING: CALCULATIONS ONLY APPLY TO BIWEEKLY PAY PERIODS");
            System.out.println("Proceed? (Y/N)");
            checkStatus();
        }

        return choice;
    }

    public static BigDecimal singleBiweeklyWithholdingRate(BigDecimal grossEarnings) {
        BigDecimal firstBracketFloor = new BigDecimal("142.00");
        BigDecimal firstBracketCeiling = new BigDecimal("509.00");

        if (grossEarnings.compareTo(firstBracketFloor) > 0 && grossEarnings.compareTo(firstBracketCeiling) <= 0) {

            BigDecimal bd = new BigDecimal("0.010");
            System.out.println("First Bracket: Returned");
            return bd;
        } else if (grossEarnings.compareTo(secondBracketFloor) > 0 && grossEarnings.compareTo(secondBracketCeiling) <= 0) {

            BigDecimal bd = new BigDecimal("0.0120");
            System.out.println("Second Bracket: Returned");
        }

        return null;
    }
}
