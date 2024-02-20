package com.myproject.mybankingsystem.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, nullable = false)
	private String accountNumber;
	private String accountHolder;
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
	private BigDecimal balance;
	private AccountType accountType;
	private Boolean closed;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("account")
	@JsonIgnore
	private List<Transactions> transactions;
}
