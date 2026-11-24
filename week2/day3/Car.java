package com.rental.vehicle;

//Inheritance: Car extends the base Vehicle class
public class Car extends Vehicle {
	private double insurancePerDay;

	public Car (String vehicleNumber, String model, double ratePerDay, int days, double insurancePerDay) {
		// Call parent Vehicle constructor using super()
        super(vehicleNumber, model, ratePerDay, days);
        this.insurancePerDay = insurancePerDay;
	}
	
	// Polymorphism: Override calculateRent() to include daily insurance charge
	@Override
	public double calculateRent() {
		return super.calculateRent() + (insurancePerDay * days);
	}
	
	// Polymorphism: Override displayDetails() for Car-specific formatting
	@Override
	public void displayDetails() {
		System.out.println("Car | " + vehicleNumber + " | " + model
				+ " | Days: " + days + " | Rent: " + calculateRent());
	}

}
