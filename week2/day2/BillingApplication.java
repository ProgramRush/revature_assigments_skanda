package com.smartstore.billing;

import java.util.Scanner;

public class BillingApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept customer and product details
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product price: ");
        double productPrice = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        // Calculate purchase and discount details
        double totalAmount = productPrice * quantity;
        double discountAmount = calculateDiscount(totalAmount);
        double discountPercentage = (discountAmount / totalAmount) * 100;
        double finalAmount = totalAmount - discountAmount;

        // Print billing details
        printBill(
            customerName,
            productName,
            totalAmount,
            discountPercentage,
            discountAmount,
            finalAmount
        );

        scanner.close();
    }

    // Calculates and returns the discount amount in rupees
    public static double calculateDiscount(double totalAmount) {
        double discountPercentage = 0.0;

        if (totalAmount >= 1000 && totalAmount <= 4999) {
            discountPercentage = 5.0;
        } else if (totalAmount >= 5000) {
            discountPercentage = 10.0;
        }

        double discountAmount =
            totalAmount * discountPercentage / 100;

        return discountAmount;
    }

    // Prints the complete billing details
    public static void printBill(
            String customerName,
            String productName,
            double totalAmount,
            double discountPercentage,
            double discountAmount,
            double finalAmount) {

        System.out.println("\n--- SmartStore Billing Details ---");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Product Name: " + productName);
        System.out.println("Total Amount: Rs. " +
            String.format("%.2f", totalAmount));
        System.out.println("Discount Percentage: " +
            discountPercentage + "%");
        System.out.println("Discount Amount: Rs. " +
            String.format("%.2f", discountAmount));
        System.out.println("Final Amount: Rs. " +
            String.format("%.2f", finalAmount));
    }
}
