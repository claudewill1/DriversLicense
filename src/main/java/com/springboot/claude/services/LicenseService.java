package com.springboot.claude.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.claude.models.License;
import com.springboot.claude.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
		
	// create a license
	public License createLicense(License license) {
		return this.licenseRepository.save(license);
	}
	
	// get license
	public Optional<License> getLicense(Long id) {
		return this.licenseRepository.findById(id);
	}
	
	public static int licenseNumber;
	
	public static int getLicenseNumber() {
		return licenseNumber;
	}
	
	public static void setLicenseNumber(int licenseNumber) {
		LicenseService.licenseNumber = licenseNumber;
	}
	
	public String stringLicenseNumber(int num) {
		String format = String.format("%06d",num);
		return format;
	}
	
	public String generateLicenseNumber() {
		License license = licenseRepository.findTopByOrderByLicenseNumberDesc();
		if(license == null) {
			return "0000001";
		}
		else {
			int newLicenseNumberUnformatted = Integer.parseInt(license.getLicenseNumber());
			newLicenseNumberUnformatted++;
			
			int numOfZeroes = 6-String.valueOf(newLicenseNumberUnformatted).length();
			
			String newLicenseNumber = Integer.toString(newLicenseNumberUnformatted);
			
			for(int i = 0; i < numOfZeroes; i++) {
				newLicenseNumber = "0" + newLicenseNumber;
			}
			return newLicenseNumber;
		}
	}
	
	
}
