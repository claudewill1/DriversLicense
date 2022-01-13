package com.springboot.claude.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.claude.models.License;
import com.springboot.claude.models.Person;
import com.springboot.claude.services.LicenseService;
import com.springboot.claude.services.PersonService;

@Controller
public class LicensesController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicensesController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.getUnlicensedPersons();
		model.addAttribute("persons",persons);
		ArrayList<String> states = new ArrayList<String>(Arrays.asList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
				"Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
				"Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
				"Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
				"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
				"Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
				"Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"));
		model.addAttribute("states",states);
		return "newlicense.jsp";
		
	}
	
	@RequestMapping(value="/addLicense",method=RequestMethod.POST)
	public String addLicense(@Valid @ModelAttribute("licenseObj") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newlicense.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/";
		}
	}
}
