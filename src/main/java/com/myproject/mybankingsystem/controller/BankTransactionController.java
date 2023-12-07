package com.myproject.mybankingsystem.controller;

import java.math.BigDecimal;
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

import com.myproject.mybankingsystem.dto.AmountWithdrawalDto;
import com.myproject.mybankingsystem.dto.TransactionsDto;
import com.myproject.mybankingsystem.entity.BankAccount;
import com.myproject.mybankingsystem.service.BankTransactionService;

@RestController
@RequestMapping("/bank/transaction")
public class BankTransactionController {

	@Autowired
	private BankTransactionService bankTransactionService;

	/**
	 * To deposit amount to the bank account.
	 * 
	 * @param accountNumber
	 * @param amount
	 * @return
	 */
	@PostMapping("/deposite")
	public ResponseEntity<BankAccount> depositeAmount(@RequestParam(value = "accountNumber") String accountNumber,
			@RequestParam(value = "amount") BigDecimal amount) {
		BankAccount updateAccount = bankTransactionService.depositeAmount(accountNumber, amount);
		return new ResponseEntity<>(updateAccount, HttpStatus.OK);
	}

	/**
	 * To withdraw amount from bank account.
	 * 
	 * @param amountWithdrawalDto
	 * @return
	 */
	@PostMapping("/withdraw")
	public ResponseEntity<BankAccount> withdrawAmount(@RequestBody AmountWithdrawalDto amountWithdrawalDto) {
		BankAccount updateAccount = bankTransactionService.withdrawAmount(amountWithdrawalDto);
		return new ResponseEntity<>(updateAccount, HttpStatus.OK);
	}

	/**
	 * To transfer money from one account to another.
	 * 
	 * @param senderAccountNumber
	 * @param receiverAccountNumber
	 * @param amount
	 * @return
	 */
	@PostMapping("/moneytransfer")
	public ResponseEntity<BankAccount> moneyTransfer(@RequestBody TransactionsDto transactionsDto) {
		BankAccount moneyTransfer = bankTransactionService.moneyTransfer(transactionsDto);
		return new ResponseEntity<>(moneyTransfer, HttpStatus.OK);
	}

	/**
	 * To fetch transaction history.
	 * 
	 * @param accountNumber
	 * @return
	 */
	@GetMapping("/transactionHistory")
	public ResponseEntity<List<TransactionsDto>> getTransactionHistory(
			@RequestParam(value = "accountNumber") String accountNumber) {
		List<TransactionsDto> trasactionHistory = bankTransactionService.getTransactions(accountNumber);
		return new ResponseEntity<>(trasactionHistory, HttpStatus.OK);
	}

	/**
	 * To fetch all transactions history.
	 * 
	 * @return
	 */
	@GetMapping("/allTransactionHistory")
	public ResponseEntity<List<TransactionsDto>> getAllTransactionsHistory() {
		List<TransactionsDto> allTransactionsHostory = bankTransactionService.getAllTransactions();
		return new ResponseEntity<>(allTransactionsHostory, HttpStatus.OK);
	}
}
