package com.capgemini.addressbook.service;

import java.util.List;

import com.capgemini.addressbook.dto.PersonDTO;
import com.capgemini.addressbook.exception.AddressbookException;
import com.capgemini.addressbook.model.Person;

public interface IAddressbookService {
	public Person addPerson(PersonDTO personDTO) throws AddressbookException;

	public Person getPersonById(Long id) throws AddressbookException;

	public Person updatePersonById(Long id, PersonDTO personDTO) throws AddressbookException;

	public void deletePersonById(Long id);

	public List<Person> getAllPersons();
}
