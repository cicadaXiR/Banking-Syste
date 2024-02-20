package com.myproject.mybankingsystem.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.myproject.mybankingsystem.entity.AccountType;
import com.myproject.mybankingsystem.entity.EmploymentStatus;
import com.myproject.mybankingsystem.entity.IdentificationProof;
import com.myproject.mybankingsystem.entity.MaritalStatus;

import lombok.Data;

@Data
public class BankAccountDto {
	
	private String accountHolder;
	private BigDecimal initialBalance;
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
	private AccountType accountType;
	private Boolean closed;
}
