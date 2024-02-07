package com.myproject.mybankingsystem.entity;


public enum PolicyType {

	LIFE("Life Insurance"),
	HEALTH("Health Insurance"),
	AUTO("Auto Insurance"),
	PROPERTY("Property Insurance");
	
	private final String displayName;
	
	PolicyType(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
