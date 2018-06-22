package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Keyboard input initialization
        Scanner keyboard = new Scanner(System.in);

        BigDecimal schoolDistricTaxRate = new BigDecimal("0.00");
        BigDecimal localTaxRate = new BigDecimal("0.00");
        BigDecimal MEDICARE_TAX_RATE = new BigDecimal("0.0145");
        BigDecimal stateTax = new BigDecimal("0.00");
        BigDecimal additionalWithholdingAmt = new BigDecimal("0.00");

        BigDecimal grossEarnings;
        BigDecimal wagesPerHour;
        BigDecimal federalTaxWithheld;
        BigDecimal netEarnings = new BigDecimal("0.00");
        BigDecimal hoursWorked;

        // Currency formatter
        DecimalFormat df = new DecimalFormat("0.00");

        // Prompts start here
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

        System.out.println("Enter additional amount withheld for income tax: ");
        System.out.println("If none, enter \"0\"");
        additionalWithholdingAmt = keyboard.nextBigDecimal();

        // Because tax bracket calculations only rely on gross earnings AFTER additional withholding, we calculate this here
        BigDecimal grossEarningsDeducted = grossEarnings.subtract(additionalWithholdingAmt);
        federalTaxWithheld = singleBiweeklyWithholding(grossEarningsDeducted);

        System.out.println("Generating report...");
        System.out.println();

        // Calls report generating method
        generateReport(grossEarnings, grossEarningsDeducted, additionalWithholdingAmt, federalTaxWithheld, hoursWorked,
                wagesPerHour);
    }

    public static void generateReport(BigDecimal grossEarnings, BigDecimal grossEarningsDeducted, BigDecimal
                                      additionalWithholdingAmt, BigDecimal federalTaxWithheld, BigDecimal hoursWorked,
                                      BigDecimal wagesPerHour) {
        // Currency formatter
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("=====REPORT=====");
        System.out.println("Hourly Wage: $" + df.format(wagesPerHour));
        System.out.println("Gross Earnings: $" + df.format(grossEarnings));
        System.out.println("Additional Withholding: $" + df.format(additionalWithholdingAmt));
        System.out.println("Federal Taxes: $" + df.format(federalTaxWithheld));
        //Unfinished
        System.out.println("State Tax: $");
        System.out.println("Local Tax: $");
        System.out.println("School District Taxes: $");
        System.out.println("Medicare: $");
        System.out.println("Net Earnings: $");
    }

    public static char checkStatus() {
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

    public static BigDecimal singleBiweeklyWithholding(BigDecimal grossEarningsDeducted) {
        // First bracket
        BigDecimal FIRST_BRACKET_FLOOR = new BigDecimal("142.00");
        BigDecimal FIRST_BRACKET_CEILING = new BigDecimal("509.00");
        // Second bracket
        BigDecimal SECOND_BRACKET_FLOOR = new BigDecimal("509.00");
        BigDecimal SECOND_BRACKET_CEILING = new BigDecimal("1631.00");
        // Third bracket
        BigDecimal THIRD_BRACKET_FLOOR = new BigDecimal("1631.00");
        BigDecimal THIRD_BRACKET_CEILING = new BigDecimal("3315.00");
        // Fourth bracket
        BigDecimal FOURTH_BRACKET_FLOOR = new BigDecimal("3315.00");
        BigDecimal FOURTH_BRACKET_CEILING = new BigDecimal("6200.00");
        // Fifth bracket
        BigDecimal FIFTH_BRACKET_FLOOR = new BigDecimal("6200.00");
        BigDecimal FIFTH_BRACKET_CEILING = new BigDecimal("7835.00");
        // Sixth bracket
        BigDecimal SIXTH_BRACKET_FLOOR = new BigDecimal("7835.00");
        BigDecimal SIXTH_BRACKET_CEILING = new BigDecimal("19373.00");
        // Seventh bracket
        BigDecimal SEVENTH_BRACKET_FLOOR = new BigDecimal("19373.00");


        if (grossEarningsDeducted.compareTo(FIRST_BRACKET_FLOOR) > 0 && grossEarningsDeducted.compareTo(FIRST_BRACKET_CEILING) <= 0) {

            BigDecimal FIRST_BRACKET_RATE = new BigDecimal("0.10");
            BigDecimal FIRST_BRACKET_AMT = new BigDecimal("0.00");

            // Calculations
            BigDecimal excessAmt = grossEarningsDeducted.subtract(FIRST_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(FIRST_BRACKET_RATE);
            BigDecimal totalWithheld = FIRST_BRACKET_AMT.add(rateDeduction);

            // Console output for testing purposes
            //System.out.println("Percentage: " + rateDeduction);
            //System.out.println("Flat amount: " + FIRST_BRACKET_AMT);
            //System.out.println("First Bracket: Returned");

            return totalWithheld;
        } else if (grossEarningsDeducted.compareTo(SECOND_BRACKET_FLOOR) > 0 && grossEarningsDeducted.compareTo(SECOND_BRACKET_CEILING) <= 0) {

            BigDecimal SECOND_BRACKET_RATE = new BigDecimal("0.12");
            BigDecimal SECOND_BRACKET_AMT = new BigDecimal("36.70");

            // Calculations
            BigDecimal excessAmt = grossEarningsDeducted.subtract(SECOND_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(SECOND_BRACKET_RATE);
            BigDecimal totalWithheld = SECOND_BRACKET_AMT.add(rateDeduction);

            // Console output for testing purposes
            //System.out.println("Percentage: " + rateDeduction);
            //System.out.println("Flat amount: " + SECOND_BRACKET_AMT);
            //System.out.println("Total: " + totalWithheld);
            //System.out.println("Second Bracket: Returned");

            return totalWithheld;
        } else if (grossEarningsDeducted.compareTo(THIRD_BRACKET_FLOOR) > 0 && grossEarningsDeducted.compareTo(THIRD_BRACKET_CEILING) <= 0) {
            BigDecimal THIRD_BRACKET_RATE = new BigDecimal("0.22");
            BigDecimal THIRD_BRACKET_AMT = new BigDecimal("171.34");

            // Calculations
            BigDecimal excessAmt = grossEarningsDeducted.subtract(THIRD_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(THIRD_BRACKET_RATE);
            BigDecimal totalWithheld = THIRD_BRACKET_AMT.add(rateDeduction);

            //System.out.println("Third Bracket: Returned");

            return totalWithheld;
        } else if (grossEarningsDeducted.compareTo(FOURTH_BRACKET_FLOOR) > 0 && grossEarningsDeducted.compareTo(FOURTH_BRACKET_CEILING) <= 0) {

            BigDecimal FOURTH_BRACKET_RATE = new BigDecimal("0.24");
            BigDecimal FOURTH_BRACKET_AMT = new BigDecimal("541.82");

            // Calculations
            BigDecimal excessAmt = grossEarningsDeducted.subtract(FOURTH_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(FOURTH_BRACKET_RATE);
            BigDecimal totalWithheld = FOURTH_BRACKET_AMT.add(rateDeduction);

            //System.out.println("Fourth Bracket: Returned");

            return totalWithheld;
        } else if (grossEarningsDeducted.compareTo(FIFTH_BRACKET_FLOOR) > 0 && grossEarningsDeducted.compareTo(FIFTH_BRACKET_CEILING) <= 0) {
            BigDecimal FIFTH_BRACKET_RATE = new BigDecimal("0.32");
            BigDecimal FIFTH_BRACKET_AMT = new BigDecimal("1234.22");

            // Calculations
            BigDecimal excessAmt = grossEarningsDeducted.subtract(FIFTH_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(FIFTH_BRACKET_RATE);
            BigDecimal totalWithheld = FIFTH_BRACKET_AMT.add(rateDeduction);

            //System.out.println("Fifth Bracket: Returned");

            return totalWithheld;
        } else if (grossEarningsDeducted.compareTo(SIXTH_BRACKET_FLOOR) > 0 && grossEarningsDeducted.compareTo(SIXTH_BRACKET_CEILING) <= 0) {
            BigDecimal SIXTH_BRACKET_RATE = new BigDecimal("0.35");
            BigDecimal SIXTH_BRACKET_AMT = new BigDecimal("1757.42");

            // Calculations
            BigDecimal excessAmt = grossEarningsDeducted.subtract(SIXTH_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(SIXTH_BRACKET_RATE);
            BigDecimal totalWithheld = SIXTH_BRACKET_AMT.add(rateDeduction);

            //System.out.println("Sixth Bracket: Returned");

            return totalWithheld;
        } else if (grossEarningsDeducted.compareTo(SEVENTH_BRACKET_FLOOR) > 0) {
            BigDecimal SEVENTH_BRACKET_RATE = new BigDecimal("0.37");
            BigDecimal SEVENTH_BRACKET_AMT = new BigDecimal("5795.72");

            // Calculations
            BigDecimal excessAmt = grossEarningsDeducted.subtract(SEVENTH_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(SEVENTH_BRACKET_RATE);
            BigDecimal totalWithheld = SEVENTH_BRACKET_AMT.add(rateDeduction);

            //System.out.println("Seventh Bracket: Returned");

            return totalWithheld;
        } else {
            //Not taxed
            BigDecimal amt = new BigDecimal("0.00");
            //System.out.println("No tax.");

            return amt;
        }
    }
}
