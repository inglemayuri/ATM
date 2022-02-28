package com.atm.entities;

public class AtmUser {
	
	long userId;
	  String UserName;
	  String userAddress;
	  double balance;
	  String userPin;
	  long phone;
	  String userEmail;
	  
	public AtmUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AtmUser(long userId, String userName, String userAddress, double balance, String userPin, long phone,
			String userEmail) {
		super();
		this.userId = userId;
		UserName = userName;
		this.userAddress = userAddress;
		this.balance = balance;
		this.userPin = userPin;
		this.phone = phone;
		this.userEmail = userEmail;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getUserPin() {
		return userPin;
	}
	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	  
	  
}
