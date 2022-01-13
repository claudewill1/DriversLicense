package com.springboot.claude.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.claude.models.Person;
import com.springboot.claude.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> getAllPersons() {
		return this.personRepository.findAll();
	}
	
	// retrieve unlicensed people
	public List<Person> getUnlicensedPersons() {
		return this.personRepository.findByLicenseIdIsNull();
	}
	
	public Person addPersion(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPerson(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.get(); 
	}
	
	public void deletePerson(Long id) {
		this.personRepository.deleteById(id);
	}
}
