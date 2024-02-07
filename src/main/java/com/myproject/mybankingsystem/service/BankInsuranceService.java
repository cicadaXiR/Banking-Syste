package com.myproject.mybankingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.mybankingsystem.dto.InsuranceFormDto;
import com.myproject.mybankingsystem.entity.InsuranceForm;
import com.myproject.mybankingsystem.repository.InsuranceRepository;

@Service
public class BankInsuranceService {
	
	@Autowired
	private InsuranceRepository insuranceRepository;
	
	/**
	 * Insurance Application.
	 * @param insuranceFormDto
	 * @return
	 */
	public InsuranceForm insuranceApplication(InsuranceFormDto insuranceFormDto) {
		InsuranceForm insuranceForm = new InsuranceForm();
		insuranceForm.setFullName(insuranceFormDto.getFullName());	
		insuranceForm.setDateOfBirth(insuranceFormDto.getDateOfBirth());
		insuranceForm.setGender(insuranceFormDto.getGender());
		insuranceForm.setMaritalStatus(insuranceFormDto.getMaritalStatus());
		insuranceForm.setResidentialAddress(insuranceFormDto.getResidentialAddress());
		insuranceForm.setMobileNumber(insuranceFormDto.getMobileNumber());
		insuranceForm.setEmail(insuranceFormDto.getEmail());
		insuranceForm.setIdentificationProof(insuranceFormDto.getIdentificationProof());
		insuranceForm.setOccupation(insuranceFormDto.getOccupation());
		insuranceForm.setEmploymentStatus(insuranceFormDto.getEmploymentStatus());
		insuranceForm.setCompanyAddress(insuranceFormDto.getCompanyAddress());
		insuranceForm.setAnnualIncome(insuranceFormDto.getAnnualIncome());
		insuranceForm.setInsuranceType(insuranceFormDto.getInsuranceType());
		insuranceForm.setCoverageAmount(insuranceFormDto.getCoverageAmount());
		return insuranceRepository.save(insuranceForm);
	}
	
	/**
	 * To get all insurance details.
	 * @return
	 */
	public List<InsuranceForm> getAllInsuranceDetails(){
		return insuranceRepository.findAll();
	}
}
