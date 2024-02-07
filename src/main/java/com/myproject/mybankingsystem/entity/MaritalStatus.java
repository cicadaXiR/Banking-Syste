package com.myproject.mybankingsystem.entity;

public enum MaritalStatus {

	SINGLE("Single"),
	MARRIED("Married"),
	DIVORCED("Devorsed");
	
	private final String maritalStatus;
	
	MaritalStatus(String maritalStatus){
		this.maritalStatus = maritalStatus;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}
}
