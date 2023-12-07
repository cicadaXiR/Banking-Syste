package com.myproject.mybankingsystem.dto;

import java.math.BigDecimal;
import com.myproject.mybankingsystem.entity.AccountType;
import lombok.Data;

@Data
public class BankAccountDto {
	
	private String accountHolder;
	private BigDecimal initialBalance;
	private AccountType accountType;
	private Boolean closed;
}
