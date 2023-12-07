package com.myproject.mybankingsystem.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class AmountWithdrawalDto {
	
	private String accountNumber;
	private BigDecimal amount;
	private String accountHolder;
	private LocalDate localDate;
}
