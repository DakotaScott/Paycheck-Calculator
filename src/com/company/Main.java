package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        TaxBrackets taxBrackets = new TaxBrackets();

        BigDecimal schoolDistricTaxRate = new BigDecimal("0.00");
        BigDecimal localTaxRate = new BigDecimal("0.00");
        final BigDecimal MEDICARE_TAX_RATE = new BigDecimal("0.0145");
        BigDecimal stateTax = new BigDecimal("0.00");
        BigDecimal additionalWithholdingAmt = new BigDecimal("0.00");
        BigDecimal federalTaxWithheld;
        BigDecimal netEarnings = new BigDecimal("0.00");

        // Currency formatter

        BigDecimal grossWages = grossWagesCalculator();

        // Because tax bracket calculations only rely on gross earnings AFTER additional withholding, we calculate this here
        BigDecimal grossWagesWithheld = additionalWithholdingCalculator(grossWages);
        System.out.println("grossWagesWithheld" + grossWagesWithheld);
        federalTaxWithheld = taxBrackets.singleBiweeklyWithholding(grossWagesWithheld);

        System.out.println("federalTaxWithheld" + federalTaxWithheld);

        System.out.println("Generating report...");
        System.out.println();

        // Calls report generating method
        generateReport(grossWages, grossWagesWithheld, additionalWithholdingAmt, federalTaxWithheld);
    }

    public static BigDecimal grossWagesCalculator() {
        BigDecimal hoursWorked;

        BigDecimal wagesPerHour;
        // Keyboard input initialization
        Scanner keyboard = new Scanner(System.in);
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

        BigDecimal grossEarnings = wagesPerHour.multiply(hoursWorked);

        return grossEarnings;
    }

    public static BigDecimal additionalWithholdingCalculator(BigDecimal grossWages) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter additional amount withheld for income tax: ");
        System.out.println("If none, enter \"0\"");
        BigDecimal additionalWithholdingAmt = keyboard.nextBigDecimal();

        additionalWithholdingAmt = grossWages.subtract(additionalWithholdingAmt);

        return additionalWithholdingAmt;
    }

    public static void generateReport(BigDecimal grossWages, BigDecimal grossWagesWithheld, BigDecimal
                                      additionalWithholdingAmt, BigDecimal federalTaxWithheld) {
        // Currency formatter
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("=====REPORT=====");
        System.out.println("Gross Earnings: $" + df.format(grossWages));
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


}
