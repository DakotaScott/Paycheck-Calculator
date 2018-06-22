package com.company;

import java.math.BigDecimal;

public class TaxBrackets {

    // This class contains all methods pertaining to tax brackets

    public static BigDecimal singleBiweeklyWithholding(BigDecimal grossWagesWithheld) {
            // First bracket constants
            final BigDecimal FIRST_BRACKET_FLOOR = new BigDecimal("142.00");
            final BigDecimal FIRST_BRACKET_CEILING = new BigDecimal("509.00");
            final BigDecimal FIRST_BRACKET_RATE = new BigDecimal("0.10");
            final BigDecimal FIRST_BRACKET_AMT = new BigDecimal("0.00");
            // Second bracket constants
            final BigDecimal SECOND_BRACKET_FLOOR = new BigDecimal("509.00");
            final BigDecimal SECOND_BRACKET_CEILING = new BigDecimal("1631.00");
            final BigDecimal SECOND_BRACKET_RATE = new BigDecimal("0.12");
            final BigDecimal SECOND_BRACKET_AMT = new BigDecimal("36.70");
            // Third bracket constants
            final BigDecimal THIRD_BRACKET_FLOOR = new BigDecimal("1631.00");
            final BigDecimal THIRD_BRACKET_CEILING = new BigDecimal("3315.00");
            final BigDecimal THIRD_BRACKET_RATE = new BigDecimal("0.22");
            final BigDecimal THIRD_BRACKET_AMT = new BigDecimal("171.34");
            // Fourth bracket constants
            final BigDecimal FOURTH_BRACKET_FLOOR = new BigDecimal("3315.00");
            final BigDecimal FOURTH_BRACKET_CEILING = new BigDecimal("6200.00");
            final BigDecimal FOURTH_BRACKET_RATE = new BigDecimal("0.24");
            final BigDecimal FOURTH_BRACKET_AMT = new BigDecimal("541.82");
            // Fifth bracket constants
            final BigDecimal FIFTH_BRACKET_FLOOR = new BigDecimal("6200.00");
            final BigDecimal FIFTH_BRACKET_CEILING = new BigDecimal("7835.00");
            final BigDecimal FIFTH_BRACKET_RATE = new BigDecimal("0.32");
            final BigDecimal FIFTH_BRACKET_AMT = new BigDecimal("1234.22");
            // Sixth bracket constants
            final BigDecimal SIXTH_BRACKET_FLOOR = new BigDecimal("7835.00");
            final BigDecimal SIXTH_BRACKET_CEILING = new BigDecimal("19373.00");
            final BigDecimal SIXTH_BRACKET_RATE = new BigDecimal("0.35");
            final BigDecimal SIXTH_BRACKET_AMT = new BigDecimal("1757.42");
            // Seventh bracket constants
            final BigDecimal SEVENTH_BRACKET_FLOOR = new BigDecimal("19373.00");
            final BigDecimal SEVENTH_BRACKET_RATE = new BigDecimal("0.37");
            final BigDecimal SEVENTH_BRACKET_AMT = new BigDecimal("5795.72");

            // Condition statements sorts gross wage amount into appropriate tax bracket
            if (grossWagesWithheld.compareTo(FIRST_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(FIRST_BRACKET_CEILING) <= 0) {

                return firstSingleBiweeklyWithholding(FIRST_BRACKET_FLOOR, grossWagesWithheld,FIRST_BRACKET_RATE, FIRST_BRACKET_AMT);

            } else if (grossWagesWithheld.compareTo(SECOND_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(SECOND_BRACKET_CEILING) <= 0) {

                return secondSingleBiweeklyWithholding(SECOND_BRACKET_FLOOR, grossWagesWithheld, SECOND_BRACKET_RATE, SECOND_BRACKET_AMT);

            } else if (grossWagesWithheld.compareTo(THIRD_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(THIRD_BRACKET_CEILING) <= 0) {

                return thirdSingleBiweeklyWithholding(THIRD_BRACKET_FLOOR, grossWagesWithheld, THIRD_BRACKET_RATE, THIRD_BRACKET_AMT);

            } else if (grossWagesWithheld.compareTo(FOURTH_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(FOURTH_BRACKET_CEILING) <= 0) {

                return fourthSingleBiweeklyWithholding(FOURTH_BRACKET_FLOOR, grossWagesWithheld, FOURTH_BRACKET_RATE, FOURTH_BRACKET_AMT);

            } else if (grossWagesWithheld.compareTo(FIFTH_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(FIFTH_BRACKET_CEILING) <= 0) {

                return fifthSingleBiweeklyWithholding(FIFTH_BRACKET_FLOOR, grossWagesWithheld, FIFTH_BRACKET_RATE, FIFTH_BRACKET_AMT);

            } else if (grossWagesWithheld.compareTo(SIXTH_BRACKET_FLOOR) > 0 && grossWagesWithheld.compareTo(SIXTH_BRACKET_CEILING) <= 0) {

                return sixthSingleBiweeklyWithholding(SIXTH_BRACKET_FLOOR, grossWagesWithheld, SIXTH_BRACKET_RATE, SIXTH_BRACKET_AMT);

            } else if (grossWagesWithheld.compareTo(SEVENTH_BRACKET_FLOOR) > 0) {

                return seventhSingleBiweeklyWithholding(SEVENTH_BRACKET_FLOOR, grossWagesWithheld, SEVENTH_BRACKET_RATE, SEVENTH_BRACKET_AMT);

            } else {
                System.out.println("Not taxed");
                BigDecimal amt = new BigDecimal("0.00");

                return amt;
            }
        }

    public static BigDecimal firstSingleBiweeklyWithholding(BigDecimal FIRST_BRACKET_FLOOR, BigDecimal grossWagesWithheld,
                                                            BigDecimal FIRST_BRACKET_RATE, BigDecimal FIRST_BRACKET_AMT) {
            // Calculations
            BigDecimal excessAmt = grossWagesWithheld.subtract(FIRST_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(FIRST_BRACKET_RATE);

            BigDecimal totalWithheld = FIRST_BRACKET_AMT.add(rateDeduction);

            System.out.println(totalWithheld);

            return totalWithheld;
        }

    public static BigDecimal secondSingleBiweeklyWithholding(BigDecimal SECOND_BRACKET_FLOOR, BigDecimal grossWagesWithheld,
                                                             BigDecimal SECOND_BRACKET_RATE, BigDecimal SECOND_BRACKET_AMT) {
            // Calculations
            BigDecimal excessAmt = grossWagesWithheld.subtract(SECOND_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(SECOND_BRACKET_RATE);
            BigDecimal totalWithheld = SECOND_BRACKET_AMT.add(rateDeduction);

            return totalWithheld;
        }

    public static BigDecimal thirdSingleBiweeklyWithholding(BigDecimal THIRD_BRACKET_FLOOR, BigDecimal grossWagesWithheld,
                                                            BigDecimal THIRD_BRACKET_RATE, BigDecimal THIRD_BRACKET_AMT) {
            // Calculations
            BigDecimal excessAmt = grossWagesWithheld.subtract(THIRD_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(THIRD_BRACKET_RATE);
            BigDecimal totalWithheld = THIRD_BRACKET_AMT.add(rateDeduction);

            return totalWithheld;
        }

    public static BigDecimal fourthSingleBiweeklyWithholding(BigDecimal FOURTH_BRACKET_FLOOR, BigDecimal grossWagesWithheld,
                                                             BigDecimal FOURTH_BRACKET_RATE, BigDecimal FOURTH_BRACKET_AMT) {
            // Calculations
            BigDecimal excessAmt = grossWagesWithheld.subtract(FOURTH_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(FOURTH_BRACKET_RATE);
            BigDecimal totalWithheld = FOURTH_BRACKET_AMT.add(rateDeduction);

            return totalWithheld;
        }

    public static BigDecimal fifthSingleBiweeklyWithholding(BigDecimal FIFTH_BRACKET_FLOOR, BigDecimal grossWagesWithheld,
                                                            BigDecimal FIFTH_BRACKET_RATE, BigDecimal FIFTH_BRACKET_AMT) {
            // Calculations
            BigDecimal excessAmt = grossWagesWithheld.subtract(FIFTH_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(FIFTH_BRACKET_RATE);
            BigDecimal totalWithheld = FIFTH_BRACKET_AMT.add(rateDeduction);

            return totalWithheld;
        }

    public static BigDecimal sixthSingleBiweeklyWithholding(BigDecimal SIXTH_BRACKET_FLOOR, BigDecimal grossWagesWithheld,
                                                            BigDecimal SIXTH_BRACKET_RATE, BigDecimal SIXTH_BRACKET_AMT) {
            // Calculations
            BigDecimal excessAmt = grossWagesWithheld.subtract(SIXTH_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(SIXTH_BRACKET_RATE);
            BigDecimal totalWithheld = SIXTH_BRACKET_AMT.add(rateDeduction);

            return totalWithheld;
        }

    public static BigDecimal seventhSingleBiweeklyWithholding(BigDecimal SEVENTH_BRACKET_FLOOR, BigDecimal grossWagesWithheld,
                                                              BigDecimal SEVENTH_BRACKET_RATE, BigDecimal SEVENTH_BRACKET_AMT) {
            // Calculations
            BigDecimal excessAmt = grossWagesWithheld.subtract(SEVENTH_BRACKET_FLOOR);
            BigDecimal rateDeduction = excessAmt.multiply(SEVENTH_BRACKET_RATE);
            BigDecimal totalWithheld = SEVENTH_BRACKET_AMT.add(rateDeduction);

            return totalWithheld;
        }

    }
