package com.rental.vehicle;

import java.util.Scanner;

public class RentalApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number of vehicles: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        
        Vehicle[] vehicles = new Vehicle[count];
        
        for(int i = 0; i < count; i++) {
        	int type;
        	
        	while (true) {
        		System.out.println("Enter type (1-Car, 2-Bike): ");
        		type = scanner.nextInt();
        		scanner.nextLine();
        		if (type == 1 || type == 2) {
        			break;
        		}
        		System.out.println("Invalid vehicle type! Please enter 1 for Car or 2 for Bike.");
        	}
        	System.out.print("Enter Vehicle Number: ");
            String vehicleNumber = scanner.nextLine();

            System.out.print("Enter Model: ");
            String model = scanner.nextLine();

            System.out.print("Enter Rate per Day: ");
            double ratePerDay = scanner.nextDouble();
            
            System.out.print("Enter Days: ");
            int days = scanner.nextInt();
            
            if (type == 1) {
                System.out.print("Enter Insurance per Day: ");
                double insurancePerDay = scanner.nextDouble();
                scanner.nextLine();
                
                // Polymorphism: Parent Vehicle reference pointing to a Car object
                Vehicle v = new Car(vehicleNumber, model, ratePerDay, days, insurancePerDay);
                vehicles[i] = v;
            }
            
            else {
            	scanner.nextLine();
            	
            	// Polymorphism: Parent Vehicle reference pointing to a Bike object
                Vehicle v = new Bike(vehicleNumber, model, ratePerDay, days);
                vehicles[i] = v;
            }
        }
        
        double totalRent = 0.0;
        System.out.println("--- Rental Details ---");
        
        // Runtime polymorphism: JVM invokes the overridden displayDetails() and calculateRent()
        for (Vehicle v : vehicles) {
        	v.displayDetails();
        	totalRent += v.calculateRent();
        }

        System.out.println("Total Rent Collected: " + totalRent);
        scanner.close();
	}

}
