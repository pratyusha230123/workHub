package com.springcore.constDI;

public class Car {
	
	public String model = "Honda HRV";
	public void carDetails() {
		System.out.println("Car Model:" +model);
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

}
