package com.myproject.mybankingsystem.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myproject.mybankingsystem.entity.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {

	List<BankAccount> findByClosedFalse();

	Optional<BankAccount> findByAccountNumber(String accountNumber);

	List<BankAccount> findByAccountHolder(String accountHolder);
	
}
