package com.week2.day4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmployeeSerializationDemo {
	public static void main(String[] args) {
		String fileName = "employees.dat";
		
		Employee[] employees = new Employee[5];
		employees[0] = new Employee(101, "Alice Johnson", "Engineering", 75000.00);
        employees[1] = new Employee(102, "Bob Smith", "Marketing", 62000.00);
        employees[2] = new Employee(103, "Charlie Brown", "Finance", 68000.00);
        employees[3] = new Employee(104, "Diana Prince", "Human Resources", 60000.00);
        employees[4] = new Employee(105, "Ethan Hunt", "Operations", 72000.00);
        
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
        	
        	oos.writeObject(employees);
        	
        	System.out.println("Employee array successfully serialized to " + fileName);

        } catch (IOException e) {
        	System.out.println("Error writing objects to file: " + e.getMessage());
        }
        
        try (FileInputStream fis = new FileInputStream(fileName); 
        		ObjectInputStream ois = new ObjectInputStream(fis)) {
        	Employee[] retrievedEmployees = (Employee[]) ois.readObject();
        	System.out.println("Retrieved Employee Details:");
        	
        	for (Employee emp : retrievedEmployees) {
        		System.out.println(emp);
        	}
        } catch (IOException | ClassNotFoundException e) {
        	System.out.println("Error reading objects from file: " + e.getMessage());
        }
	}
}
