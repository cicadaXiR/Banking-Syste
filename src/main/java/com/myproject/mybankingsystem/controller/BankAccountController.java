package com.myproject.mybankingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.mybankingsystem.dto.BankAccountDto;
import com.myproject.mybankingsystem.entity.BankAccount;
import com.myproject.mybankingsystem.service.BankAccountService;

@RestController
@RequestMapping("/bank/auth/account")
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;

	/**
	 * To create an bank account.
	 * 
	 * @param bankAccountDto
	 * @return
	 */
	@PostMapping("/createAccount")
	public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccountDto bankAccountDto) {
		BankAccount account = bankAccountService.createAccont(bankAccountDto);
		return new ResponseEntity<>(account, HttpStatus.CREATED);
	}

	/**
	 * To fetch all bank account details.
	 * 
	 * @return
	 */
	@GetMapping("/accountList")
	public ResponseEntity<List<BankAccount>> getAccountsList() {
		List<BankAccount> accountList = bankAccountService.getAllAccounts();
		return new ResponseEntity<>(accountList, HttpStatus.OK);
	}

	/**
	 * To fetch account details by account number.
	 * 
	 * @param accountNumber
	 * @return
	 */
	@GetMapping("/getAccountByAccountNumber")
	public ResponseEntity<BankAccount> getAccountByAccountNumber(
			@RequestParam(value = "accountNumber") String accountNumber) {
		BankAccount bankAccount = bankAccountService.getAccountByAccountNumber(accountNumber);
		return new ResponseEntity<>(bankAccount, HttpStatus.OK);
	}

	/**
	 * To fetch account details by account holder.
	 * 
	 * @param accountHolder
	 * @return
	 */
	@GetMapping("/holder/getAccountByAccountHolder")
	public ResponseEntity<List<BankAccountDto>> getAccountByAccountHolder(
			@RequestParam(value = "accountHolder") String accountHolder) {
		List<BankAccountDto> bankAccountHolder = bankAccountService.getAccountByAccountHolder(accountHolder);
		return new ResponseEntity<>(bankAccountHolder, HttpStatus.OK);
	}

	/**
	 * To close the account by account number.
	 * 
	 * @param accountNumber
	 * @return
	 */
	@PostMapping("/close/closeAccount")
	public ResponseEntity<String> closeBankAccount(@RequestParam String accountNumber) {
		bankAccountService.closeAccount(accountNumber);
		return new ResponseEntity<>("Account closed suessfully", HttpStatus.OK);
	}
}
