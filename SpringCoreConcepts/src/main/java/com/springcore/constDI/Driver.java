package com.springcore.constDI;

public class Driver{
	
	public String driverName = "Abhijth";
	public void driverDetails() {
		System.out.println("Driver Name:"+driverName);
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

}
