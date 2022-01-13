package com.springboot.claude.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.claude.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	public List<Person> findAll();
	
	@Query(value="SELECT p.* FROM persons AS p LEFT JOIN licenses AS 1 ON p.id = 1.person_id WHERE l.id IS NULL",nativeQuery=true)
	public List<Person> findByNoLicense();
	public List<Person> findByLicenseIdIsNull();
}
