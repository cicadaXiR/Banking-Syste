package com.myproject.mybankingsystem.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.myproject.mybankingsystem.entity.EmploymentStatus;
import com.myproject.mybankingsystem.entity.IdentificationProof;
import com.myproject.mybankingsystem.entity.MaritalStatus;
import com.myproject.mybankingsystem.entity.PolicyType;

import lombok.Data;

@Data
public class InsuranceFormDto {

	private String fullName;
	private Date dateOfBirth;
	private String gender;
	private MaritalStatus maritalStatus;
	private String residentialAddress;
	private String mobileNumber;
	private String email;
	private IdentificationProof identificationProof;
	private String occupation;
	private String companyAddress;
	private EmploymentStatus employmentStatus;
	private BigDecimal annualIncome;	
	private PolicyType insuranceType;
	private BigDecimal coverageAmount;
}
