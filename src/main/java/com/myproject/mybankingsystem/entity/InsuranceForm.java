package com.myproject.mybankingsystem.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
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
