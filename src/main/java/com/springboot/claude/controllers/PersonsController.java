package com.springboot.claude.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.claude.models.Person;
import com.springboot.claude.services.LicenseService;
import com.springboot.claude.services.PersonService;

@Controller
public class PersonsController {
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public PersonsController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "index.jsp";
	}
	
	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person, Model model) {
		return "newperson.jsp";
	}
	@PostMapping("/addPerson")
	public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newperson.jsp";
		} 
		else {
			personService.addPersion(person);
			return "redirect:/";
		}
	}
	
	@GetMapping("/persons/{id}")
	public String viewPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("license",licenseService.getLicense(id).get());
		return "view.jsp";
	}
	
	@GetMapping("/persons/delete/{id}")
	public String deletePerson(@PathVariable("id") Long id) {
		personService.deletePerson(id);
		return "redirect:/";
	}
}
