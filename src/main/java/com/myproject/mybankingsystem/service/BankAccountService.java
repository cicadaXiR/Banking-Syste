package com.myproject.mybankingsystem.service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.mybankingsystem.dto.BankAccountDto;
import com.myproject.mybankingsystem.entity.BankAccount;
import com.myproject.mybankingsystem.repository.BankAccountRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	
	
	/**
	 * To create an new bank account.
	 * @param bankAccountDto
	 * @return
	 */
	public BankAccount createAccont(BankAccountDto bankAccountDto) {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountHolder(bankAccountDto.getAccountHolder());
		bankAccount.setAccountNumber(generateAccountNumber());
		
		bankAccount.setDateOfBirth(bankAccountDto.getDateOfBirth());
		bankAccount.setEmail(bankAccountDto.getEmail());
		bankAccount.setGender(bankAccountDto.getGender());
		bankAccount.setMaritalStatus(bankAccountDto.getMaritalStatus());
		bankAccount.setMobileNumber(bankAccountDto.getMobileNumber());
		bankAccount.setResidentialAddress(bankAccountDto.getResidentialAddress());
		bankAccount.setOccupation(bankAccountDto.getOccupation());
		bankAccount.setIdentificationProof(bankAccountDto.getIdentificationProof());
		bankAccount.setMaritalStatus(bankAccountDto.getMaritalStatus());
		bankAccount.setAnnualIncome(bankAccountDto.getAnnualIncome());
		
		bankAccount.setAccountType(bankAccountDto.getAccountType());
		bankAccount.setBalance(bankAccountDto.getInitialBalance());
		bankAccount.setClosed(false);
		return bankAccountRepository.save(bankAccount);
	}
	
	
	
	/**
	 * To fetch the all bank account details.
	 * @return
	 */
	public List<BankAccount> getAllAccounts() {
		return bankAccountRepository.findByClosedFalse();
	}
	
	
	
	/**
	 * To fetch the account details based on account number.
	 * @param accountNumber
	 * @return
	 */
	public BankAccount getAccountByAccountNumber(String accountNumber) {
		return bankAccountRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new EntityNotFoundException("Account Not Found"+ accountNumber));
	}
	

	
	
	/**
	 * To fetch the account details based account holder name.
	 * @param accountHolder
	 * @return
	 */
	public List<BankAccountDto> getAccountByAccountHolder(String accountHolder){
		List<BankAccount> bankAccount = bankAccountRepository.findByAccountHolder(accountHolder);
		return bankAccount.stream()
				.map(accounts ->{
					BankAccountDto bankAccountDto = new BankAccountDto();
					bankAccountDto.setAccountHolder(accounts.getAccountHolder());
					bankAccountDto.setAccountType(accounts.getAccountType());
					bankAccountDto.setInitialBalance(accounts.getBalance());
					bankAccountDto.setClosed(accounts.getClosed());
					return bankAccountDto;
				}).collect(Collectors.toList());
	}
	
	public BankAccountDto getBalance(String balance) {
		return null;
	}
	
	
	/**
	 * To close an existing bank account.
	 * @param accountNumber
	 */
	public void closeAccount(String accountNumber) {
		BankAccount closeAccount = getAccountByAccountNumber(accountNumber);
		closeAccount.setClosed(true);
		bankAccountRepository.save(closeAccount);
	}
	
	
	
	
	/**
	 * To generates the account number
	 * @return
	 */
	private String generateAccountNumber() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String alphaNumeric = uuid.substring(0,12);
		return alphaNumeric.toUpperCase();
	}
}
