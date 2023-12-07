package com.myproject.mybankingsystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myproject.mybankingsystem.entity.Transactions;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Long>{
	
	List<Transactions> findByAccountNumber(String accountNumber);
}
