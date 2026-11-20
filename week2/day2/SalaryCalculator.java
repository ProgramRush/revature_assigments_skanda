package com.smartstore.billing;

import java.util.Scanner;

public class SalaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read employee details
        System.out.print("Enter employee ID: ");
        String employeeId = scanner.nextLine();

        System.out.print("Enter employee name: ");
        String employeeName = scanner.nextLine();

        System.out.print("Enter basic salary: ");
        double basicSalary = scanner.nextDouble();

        // Calculate salary components
        double hra = basicSalary * 20 / 100;
        double da = basicSalary * 10 / 100;
        double grossSalary = calculateGross(basicSalary);
        double professionalTax =
            calculateProfessionalTax(grossSalary);
        double netSalary = grossSalary - professionalTax;

        // Print employee salary details
        System.out.println("\nEmployee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Basic Salary: Rs. " +
            String.format("%.2f", basicSalary));
        System.out.println("HRA: Rs. " +
            String.format("%.2f", hra));
        System.out.println("DA: Rs. " +
            String.format("%.2f", da));
        System.out.println("Gross Salary: Rs. " +
            String.format("%.2f", grossSalary));
        System.out.println("Professional Tax: Rs. " +
            String.format("%.2f", professionalTax));
        System.out.println("Net Salary: Rs. " +
            String.format("%.2f", netSalary));

        scanner.close();
    }

    // Calculates gross salary as basic + 20% HRA + 10% DA
    public static double calculateGross(double basic) {
        double hra = basic * 20 / 100;
        double da = basic * 10 / 100;

        return basic + hra + da;
    }

    // Deducts professional tax of Rs. 200 when gross is above Rs. 20,000
    public static double calculateProfessionalTax(double gross) {
        if (gross > 20000) {
            return 200.0;
        }

        return 0.0;
    }
}

