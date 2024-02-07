package com.myproject.mybankingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.mybankingsystem.entity.InsuranceForm;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuranceForm, Long>{
	
	//List<InsuranceForm> findByFormDetails();
}