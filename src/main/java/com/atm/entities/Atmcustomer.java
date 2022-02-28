package com.atm.entities;

public class Atmcustomer {
	
		 int customerId; //Camel Case
		   String customerName;
		  String pin;
		
	public Atmcustomer() {
		super();
		// TODO Auto-generated constructor stub
		
		
	}

	public Atmcustomer(int customerId, String customerName, String pin) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.pin = pin;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	
	   
}
