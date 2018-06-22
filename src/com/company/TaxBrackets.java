package com.company;

import java.math.BigDecimal;

public class TaxBrackets {

    // This class contains all methods pertaining to tax brackets

    public static BigDecimal singleBiweeklyWithholding(BigDecimal grossWagesWithheld) {
        // First bracket constants
        final BigDecimal FIRST_BRACKET_FLOOR = new BigDecimal("142.00");
        final BigDecimal FIRST_BRACKET_CEILING = new BigDecimal("509.00");
        // Second bracket constants
        final BigDecimal SECOND_BRACKET_FLOOR = new BigDecimal("509.00");
        final BigDecimal SECOND_BRACKET_CEILING = new BigDecimal("1631.00");
        // Third bracket constants
        final BigDecimal THIRD_BRACKET_FLOOR = new BigDecimal("1631.00");
        final BigDecimal THIRD_BRACKET_CEILING = new BigDecimal("3315.00");
        // Fourth bracket constants
        final BigDecimal FOURTH_BRACKET_FLOOR = new BigDecimal("3315.00");
        final BigDecimal FOURTH_BRACKET_CEILING = new BigDecimal("6200.00");
        // Fifth bracket constants
        final BigDecimal FIFTH_BRACKET_FLOOR = new BigDecimal("6200.00");
        final BigDecimal FIFTH_BRACKET_CEILING = new BigDecimal("7835.00");
        // Sixth bracket constants
        final BigDecimal SIXTH_BRACKET_FLOOR = new BigDecimal("7835.00");
        final BigDecimal SIXTH_BRACKET_CEILING = new BigDecimal("19373.00");
        // Seventh bracket constants
        final BigDecimal SEVENTH_BRACKET_FLOOR = new BigDecimal("19373.00");

        // Condition statements sorts gross wage amount into appropriate tax bracket
        if (grossWagesWithheld.compareTo(FIRST_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(FIRST_BRACKET_CEILING) <= 0) {

            return firstSingleBiweeklyWithholding(FIRST_BRACKET_FLOOR, grossWagesWithheld);

        } else if (grossWagesWithheld.compareTo(SECOND_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(SECOND_BRACKET_CEILING) <= 0) {

            return secondSingleBiweeklyWithholding(SECOND_BRACKET_FLOOR, grossWagesWithheld);

        } else if (grossWagesWithheld.compareTo(THIRD_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(THIRD_BRACKET_CEILING) <= 0) {

            return thirdSingleBiweeklyWithholding(THIRD_BRACKET_FLOOR, grossWagesWithheld);

        } else if (grossWagesWithheld.compareTo(FOURTH_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(FOURTH_BRACKET_CEILING) <= 0) {

            return fourthSingleBiweeklyWithholding(FOURTH_BRACKET_FLOOR, grossWagesWithheld);

        } else if (grossWagesWithheld.compareTo(FIFTH_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(FIFTH_BRACKET_CEILING) <= 0) {

            return fifthSingleBiweeklyWithholding(FIFTH_BRACKET_FLOOR, grossWagesWithheld);

        } else if (grossWagesWithheld.compareTo(SIXTH_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(SIXTH_BRACKET_CEILING) <= 0) {

            return sixthSingleBiweeklyWithholding(SIXTH_BRACKET_FLOOR, grossWagesWithheld);

        } else if (grossWagesWithheld.compareTo(SEVENTH_BRACKET_FLOOR) > 0) {

            return seventhSingleBiweeklyWithholding(SEVENTH_BRACKET_FLOOR, grossWagesWithheld);

        } else {
            System.out.println("Not taxed");
            BigDecimal amt = new BigDecimal("0.00");

            return amt;
        }
    }

    public static BigDecimal firstSingleBiweeklyWithholding(BigDecimal FIRST_BRACKET_FLOOR, BigDecimal grossWagesWithheld) {
        BigDecimal FIRST_BRACKET_RATE = new BigDecimal("0.10");
        BigDecimal FIRST_BRACKET_AMT = new BigDecimal("0.00");
        // Calculations
        BigDecimal excessAmt = grossWagesWithheld.subtract(FIRST_BRACKET_FLOOR);
        BigDecimal rateDeduction = excessAmt.multiply(FIRST_BRACKET_RATE);

        BigDecimal totalWithheld = FIRST_BRACKET_AMT.add(rateDeduction);

        System.out.println(totalWithheld);

        return totalWithheld;
    }

    public static BigDecimal secondSingleBiweeklyWithholding(BigDecimal SECOND_BRACKET_FLOOR, BigDecimal grossWagesWithheld) {
        BigDecimal SECOND_BRACKET_RATE = new BigDecimal("0.12");
        BigDecimal SECOND_BRACKET_AMT = new BigDecimal("36.70");

        // Calculations
        BigDecimal excessAmt = grossWagesWithheld.subtract(SECOND_BRACKET_FLOOR);
        BigDecimal rateDeduction = excessAmt.multiply(SECOND_BRACKET_RATE);
        BigDecimal totalWithheld = SECOND_BRACKET_AMT.add(rateDeduction);

        return totalWithheld;
    }

    public static BigDecimal thirdSingleBiweeklyWithholding(BigDecimal THIRD_BRACKET_FLOOR, BigDecimal grossWagesWithheld) {
        BigDecimal THIRD_BRACKET_RATE = new BigDecimal("0.22");
        BigDecimal THIRD_BRACKET_AMT = new BigDecimal("171.34");

        // Calculations
        BigDecimal excessAmt = grossWagesWithheld.subtract(THIRD_BRACKET_FLOOR);
        BigDecimal rateDeduction = excessAmt.multiply(THIRD_BRACKET_RATE);
        BigDecimal totalWithheld = THIRD_BRACKET_AMT.add(rateDeduction);

        return totalWithheld;
    }

    public static BigDecimal fourthSingleBiweeklyWithholding(BigDecimal FOURTH_BRACKET_FLOOR, BigDecimal grossWagesWithheld) {
        BigDecimal FOURTH_BRACKET_RATE = new BigDecimal("0.24");
        BigDecimal FOURTH_BRACKET_AMT = new BigDecimal("541.82");

        // Calculations
        BigDecimal excessAmt = grossWagesWithheld.subtract(FOURTH_BRACKET_FLOOR);
        BigDecimal rateDeduction = excessAmt.multiply(FOURTH_BRACKET_RATE);
        BigDecimal totalWithheld = FOURTH_BRACKET_AMT.add(rateDeduction);

        return totalWithheld;
    }

    public static BigDecimal fifthSingleBiweeklyWithholding(BigDecimal FIFTH_BRACKET_FLOOR, BigDecimal grossWagesWithheld) {
        BigDecimal FIFTH_BRACKET_RATE = new BigDecimal("0.32");
        BigDecimal FIFTH_BRACKET_AMT = new BigDecimal("1234.22");

        // Calculations
        BigDecimal excessAmt = grossWagesWithheld.subtract(FIFTH_BRACKET_FLOOR);
        BigDecimal rateDeduction = excessAmt.multiply(FIFTH_BRACKET_RATE);
        BigDecimal totalWithheld = FIFTH_BRACKET_AMT.add(rateDeduction);

        return totalWithheld;
    }

    public static BigDecimal sixthSingleBiweeklyWithholding(BigDecimal SIXTH_BRACKET_FLOOR, BigDecimal grossWagesWithheld) {
        BigDecimal SIXTH_BRACKET_RATE = new BigDecimal("0.35");
        BigDecimal SIXTH_BRACKET_AMT = new BigDecimal("1757.42");

        // Calculations
        BigDecimal excessAmt = grossWagesWithheld.subtract(SIXTH_BRACKET_FLOOR);
        BigDecimal rateDeduction = excessAmt.multiply(SIXTH_BRACKET_RATE);
        BigDecimal totalWithheld = SIXTH_BRACKET_AMT.add(rateDeduction);

        return totalWithheld;
    }

    public static BigDecimal seventhSingleBiweeklyWithholding(BigDecimal SEVENTH_BRACKET_FLOOR, BigDecimal grossWagesWithheld) {
        BigDecimal SEVENTH_BRACKET_RATE = new BigDecimal("0.37");
        BigDecimal SEVENTH_BRACKET_AMT = new BigDecimal("5795.72");

        // Calculations
        BigDecimal excessAmt = grossWagesWithheld.subtract(SEVENTH_BRACKET_FLOOR);
        BigDecimal rateDeduction = excessAmt.multiply(SEVENTH_BRACKET_RATE);
        BigDecimal totalWithheld = SEVENTH_BRACKET_AMT.add(rateDeduction);

        return totalWithheld;
    }
}
