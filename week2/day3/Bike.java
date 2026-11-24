package com.rental.vehicle;

//Inheritance: Bike extends the base Vehicle class
public class Bike extends Vehicle {
	
	public Bike(String vehicleNumber, String model, double ratePerDay, int days) {
        // Call parent Vehicle constructor using super()
        super(vehicleNumber, model, ratePerDay, days);
    }
	
	// Polymorphism: Override calculateRent() to apply a 10% discount
	@Override
	public double calculateRent() {
		return super.calculateRent() * 0.90;
	}
	
	// Polymorphism: Override displayDetails() for Bike-specific formatting
	@Override
	public void displayDetails() {
		System.out.println("Bike | " + vehicleNumber + " | " + model
				+ " | Days: " + days + " | Rent: " + calculateRent());
	}
}
