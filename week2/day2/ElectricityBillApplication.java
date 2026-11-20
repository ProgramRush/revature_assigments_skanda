package com.citypower.billing;

import java.util.Scanner;

public class ElectricityBillApplication {

    // Limits and rates
    private static final int FIRST_SLAB_UNITS = 100;
    private static final int SECOND_SLAB_UNITS = 300;
    private static final double FIRST_SLAB_RATE = 3.00;
    private static final double SECOND_SLAB_RATE = 5.00;
    private static final double THIRD_SLAB_RATE = 7.50;

    // Fixed charges and surcharge rules
    private static final double FIXED_CHARGE = 50.0;
    private static final double SURCHARGE_LIMIT = 2000.0;
    private static final double SURCHARGE_RATE = 0.05;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read consumer details
        System.out.print("Enter consumer number: ");
        String consumerNumber = scanner.nextLine();

        System.out.print("Enter consumer name: ");
        String consumerName = scanner.nextLine();

        System.out.print("Enter previous meter reading: ");
        int prevReading = scanner.nextInt();

        System.out.print("Enter current meter reading: ");
        int currReading = scanner.nextInt();

        // Calculate the number of consumed units
        int units = currReading - prevReading;

        // Stop processing when the meter readings are invalid
        if (currReading < prevReading) {
            System.out.println(
                "Error: Current meter reading cannot be less than previous meter reading."
            );
            scanner.close();
            return;
        }

        double energyCharge = calculateEnergyCharge(units);
        double surcharge = calculateSurcharge(energyCharge);
        double totalAmount =
            calculateTotal(energyCharge);

        printBill(
            consumerNumber,
            consumerName,
            prevReading,
            currReading,
            units,
            energyCharge,
            surcharge,
            totalAmount
        );

        scanner.close();
    }

    // Calculates the progressive energy charge
    public static double calculateEnergyCharge(int units) {
        double energyCharge = 0.0;

        if (units <= FIRST_SLAB_UNITS) {
            // All units belong to the first slab
            energyCharge = units * FIRST_SLAB_RATE;
        } else if (units <= SECOND_SLAB_UNITS) {
            // First slab plus the units from 101 to 300
            energyCharge =
                (FIRST_SLAB_UNITS * FIRST_SLAB_RATE) +
                ((units - FIRST_SLAB_UNITS) * SECOND_SLAB_RATE);
        } else {
            // First slab, second slab, and units above 300
            energyCharge =
                (FIRST_SLAB_UNITS * FIRST_SLAB_RATE) +
                ((SECOND_SLAB_UNITS - FIRST_SLAB_UNITS)
                    * SECOND_SLAB_RATE) +
                ((units - SECOND_SLAB_UNITS) * THIRD_SLAB_RATE);
        }

        return energyCharge;
    }

    // Calculates the surcharge based on the energy charge
    public static double calculateSurcharge(double energyCharge) {
        double surcharge = 0.0;

        // The surcharge applies only when the charge is strictly above the limit
        if (energyCharge > SURCHARGE_LIMIT) {
            surcharge = energyCharge * SURCHARGE_RATE;
        }

        return surcharge;
    }

    // Calculates the final bill amount
    public static double calculateTotal(double energyCharge) {
        double surcharge = calculateSurcharge(energyCharge);
        double totalAmount =
            energyCharge + FIXED_CHARGE + surcharge;

        return totalAmount;
    }

    // Prints the complete electricity bill
    public static void printBill(
            String consumerNumber,
            String consumerName,
            int prevReading,
            int currReading,
            int units,
            double energyCharge,
            double surcharge,
            double totalAmount) {

        System.out.println("\n--- CityPower Electricity Bill ---");
        System.out.println("Consumer Number: " + consumerNumber);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Previous Reading: " + prevReading);
        System.out.println("Current Reading: " + currReading);
        System.out.println("Units Consumed: " + units);
        System.out.println("Energy Charge: Rs. " +
            String.format("%.2f", energyCharge));
        System.out.println("Fixed Charge: Rs. " +
            String.format("%.2f", FIXED_CHARGE));
        System.out.println("Surcharge: Rs. " +
            String.format("%.2f", surcharge));
        System.out.println("Total Bill Amount: Rs. " +
            String.format("%.2f", totalAmount));
    }
}
