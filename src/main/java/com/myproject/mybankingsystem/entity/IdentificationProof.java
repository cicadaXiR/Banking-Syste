package com.myproject.mybankingsystem.entity;

public enum IdentificationProof {

	AADHARID("AadharId"),
	LICENSENO("LicenceNumber"),
	VOTERID("VoterId");
	
	private final String proof;
	
	IdentificationProof(String proof){
		this.proof = proof;
	}

	public String getProof() {
		return proof;
	}
	
}
