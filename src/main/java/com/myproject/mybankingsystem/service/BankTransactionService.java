package com.myproject.mybankingsystem.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.mybankingsystem.dto.AmountWithdrawalDto;
import com.myproject.mybankingsystem.dto.TransactionsDto;
import com.myproject.mybankingsystem.entity.BankAccount;
import com.myproject.mybankingsystem.entity.Transactions;
import com.myproject.mybankingsystem.exceptions.InsufficientFundException;
import com.myproject.mybankingsystem.repository.BankAccountRepository;
import com.myproject.mybankingsystem.repository.TransactionsRepository;

@Service
public class BankTransactionService {

	@Autowired
	private BankAccountRepository bankAccountRepository;
	@Autowired
	private TransactionsRepository transactionsRepository;
	@Autowired
	private BankAccountService bankAccountService;

	/**
	 * To deposit amount to bank account.
	 * 
	 * @param accountNumber
	 * @param amount
	 * @return
	 */
	@Transactional
	public BankAccount depositeAmount(String accountNumber, BigDecimal amount) {
		BankAccount bankAccount = bankAccountService.getAccountByAccountNumber(accountNumber);
		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Deposite amount must be greater than zero.");
		}
		bankAccount.setBalance(bankAccount.getBalance().add(amount));
		return bankAccountRepository.save(bankAccount);
	}

	/**
	 * To withdraw amount from bank account.
	 * 
	 * @param amountWithdrawalDto
	 * @return
	 */
	@Transactional
	public BankAccount withdrawAmount(AmountWithdrawalDto amountWithdrawalDto) {
		String accountNumber = amountWithdrawalDto.getAccountNumber();
		BigDecimal amount = amountWithdrawalDto.getAmount();
		BankAccount account = bankAccountService.getAccountByAccountNumber(accountNumber);

		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Withdawal amount must be greater than zero.");
		}
		if (amount.compareTo(account.getBalance()) > 0) {
			throw new IllegalArgumentException("Insufficient amount.");
		}

		account.setBalance(account.getBalance().subtract(amount));

		Transactions withdrawalTransactions = new Transactions();
		withdrawalTransactions.setAccount(account);
		withdrawalTransactions.setAmount(amount);
		withdrawalTransactions.setTransactionType("withdrawal");
		withdrawalTransactions.setAccountHolder(amountWithdrawalDto.getAccountHolder());
		withdrawalTransactions.setAccountNumber(accountNumber);
		withdrawalTransactions.setTransactionDate(LocalDate.now());
		account.getTransactions().add(withdrawalTransactions);

		transactionsRepository.save(withdrawalTransactions);
		bankAccountRepository.save(account);
		return account;
	}

	/**
	 * To transfer money from one account to another.
	 * @param senderAccountNumber
	 * @param receiverAccountNumber
	 * @param amount
	 */
	@Transactional
	public BankAccount moneyTransfer(TransactionsDto transactionsDto) {
		String senderAccountNumber = transactionsDto.getSenderAccountNumber();
		String receiverAccountNumber = transactionsDto.getReceiverAccountNumber();
		BigDecimal amount = transactionsDto.getAmount();
		
		Optional<BankAccount> senderAccount = bankAccountRepository.findByAccountNumber(senderAccountNumber);
		Optional<BankAccount> receiverAccount = bankAccountRepository.findByAccountNumber(receiverAccountNumber);
		
		BankAccount senderAccount1 = senderAccount
				.orElseThrow(() -> new IllegalArgumentException("sender account not found:" + senderAccountNumber));

		BankAccount receiverAccount1 = receiverAccount
				.orElseThrow(() -> new IllegalArgumentException("receiver account not found:" + receiverAccountNumber));

		
		if (senderAccount.get().getBalance().compareTo(amount) < 0) {
			throw new InsufficientFundException("Insufficient balance for transfer.");
		}

		senderAccount.get().setBalance(senderAccount.get().getBalance().subtract(amount));
		bankAccountRepository.save(senderAccount1);

		receiverAccount.get().setBalance(receiverAccount.get().getBalance().add(amount));
		bankAccountRepository.save(receiverAccount1);

		Transactions senderTransactions = new Transactions();
		senderTransactions.setAmount(amount);
		senderTransactions.setTransactionType("Debit");
		senderTransactions.setAccountHolder(senderAccount1.getAccountHolder());
		senderTransactions.setTransactionDate(LocalDate.now());
		senderTransactions.setAccountNumber(senderAccount1.getAccountNumber());
		senderTransactions.setAccount(senderAccount1);
		
		senderAccount.get().getTransactions().add(senderTransactions);
		transactionsRepository.save(senderTransactions);

		Transactions receiverTransactions = new Transactions();
		receiverTransactions.setAmount(amount);
		receiverTransactions.setTransactionType("Credit");
		receiverTransactions.setAccountHolder(receiverAccount1.getAccountHolder());
		receiverTransactions.setTransactionDate(LocalDate.now());
		receiverTransactions.setAccountNumber(receiverAccountNumber);
		receiverTransactions.setAccount(receiverAccount1);
		
		receiverAccount.get().getTransactions().add(receiverTransactions);
		transactionsRepository.save(receiverTransactions);
		
		return senderAccount1;
	}

	/**
	 * To fetch transaction history of individual accounts.
	 * 
	 * @param accountNumber
	 * @return
	 */
	public List<TransactionsDto> getTransactions(String accountNumber) {
		List<Transactions> trasactions = transactionsRepository.findByAccountNumber(accountNumber);
		return trasactions.stream().map(transaction -> {
			TransactionsDto transactionsDto = new TransactionsDto();
			transactionsDto.setAccountNumber(transaction.getAccountNumber());
			transactionsDto.setAccountHolder(transaction.getAccountHolder());
			transactionsDto.setAmount(transaction.getAmount());
			transactionsDto.setTransactionType(transaction.getTransactionType());
			transactionsDto.setTransactionDate(transaction.getTransactionDate());
			return transactionsDto;
		}).collect(Collectors.toList());
	}
	
	/**
	 * To fetch all transactions history.
	 * @return
	 */
	public List<TransactionsDto> getAllTransactions(){
		List<Transactions> allTransaction = transactionsRepository.findAll();
		return allTransaction.stream().map(allTransactions ->{
			TransactionsDto allTransactionsDto = new TransactionsDto();
			allTransactionsDto.setAccountNumber(allTransactions.getAccountNumber());
			allTransactionsDto.setAccountHolder(allTransactions.getAccountHolder());
			allTransactionsDto.setAmount(allTransactions.getAmount());
			allTransactionsDto.setTransactionType(allTransactions.getTransactionType());
			allTransactionsDto.setTransactionDate(allTransactions.getTransactionDate());
			return allTransactionsDto;
		}).collect(Collectors.toList());
	}
}
