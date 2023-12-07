package com.myproject.mybankingsystem.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class TransactionsDto {
	
	private String accountNumber;
	private String senderAccountNumber;
	private String receiverAccountNumber;
	private BigDecimal amount;
	private String accountHolder;
	private String transactionType;
	private LocalDate transactionDate;
}
