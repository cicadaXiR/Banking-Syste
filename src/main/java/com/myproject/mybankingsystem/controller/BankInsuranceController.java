package com.myproject.mybankingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.mybankingsystem.dto.InsuranceFormDto;
import com.myproject.mybankingsystem.entity.InsuranceForm;
import com.myproject.mybankingsystem.service.BankInsuranceService;

@RestController
@RequestMapping("/bank/auth/insurance")
@CrossOrigin("http://localhost:3000")
public class BankInsuranceController {

	@Autowired
	private BankInsuranceService bankInsuranceService;
	
	/**
	 * Insurance application form.
	 * @param insuranceFormDto
	 * @return
	 */
	@PostMapping("/applyInsurance")
	public ResponseEntity<InsuranceForm> applyInsurance(@RequestBody InsuranceFormDto insuranceFormDto){
		InsuranceForm insuranceForm = bankInsuranceService.insuranceApplication(insuranceFormDto);
		return new ResponseEntity<>(insuranceForm, HttpStatus.CREATED);
	}
	
	/**
	 * To get insurance form details.
	 * @return
	 */
	@GetMapping("/insuranseDetails")
	public ResponseEntity<List<InsuranceForm>> getAllInsuranceDetails(){
		List<InsuranceForm> insuranceFormDetails = bankInsuranceService.getAllInsuranceDetails();
		return new ResponseEntity<>(insuranceFormDetails, HttpStatus.OK);
	}
}
