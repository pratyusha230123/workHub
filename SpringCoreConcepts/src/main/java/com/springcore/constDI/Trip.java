package com.springcore.constDI;

public class Trip {
	Car car;
	Driver driver;
	Passenger passenger;
	
	public Trip() {
		
	}
	public Trip(Car car, Driver driver, Passenger passenger) {
		
		this.car = car;
		this.driver = driver;
		this.passenger = passenger;
	}
	
	public void displayInfo() {
		car.carDetails();
		driver.driverDetails();
		passenger.passgnrDetails();
	}

}
