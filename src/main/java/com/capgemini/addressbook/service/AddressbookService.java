package com.capgemini.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.addressbook.dto.PersonDTO;
import com.capgemini.addressbook.exception.AddressbookException;
import com.capgemini.addressbook.model.Person;
import com.capgemini.addressbook.repository.IAddressbookRepository;

@Service
public class AddressbookService implements IAddressbookService {
	@Autowired
	IAddressbookRepository addbookRepo;

	@Override
	public Person addPerson(PersonDTO personDTO) throws AddressbookException {
		long count = addbookRepo.count();
		Person person = new Person(count + 1, personDTO);
		addbookRepo.save(person);
		return addbookRepo.findById(count + 1).orElseThrow(() -> new AddressbookException("Contact Not Added"));
	}

	@Override
	public Person getPersonById(Long id) throws AddressbookException {
		return addbookRepo.findById(id).orElseThrow(() -> new AddressbookException("Invalid User id"));
	}

	@Override
	public Person updatePersonById(Long id, PersonDTO personDTO) throws AddressbookException {
		Person person = getPersonById(id);
		person.setFirstName(personDTO.getFirstName());
		person.setLastName(personDTO.getLastName());
		person.setContact(personDTO.getContact());
		person.setAddress(personDTO.getAddress());
		person.setCity(personDTO.getCity());
		person.setState(personDTO.getState());
		person.setZip(personDTO.getZip());
		addbookRepo.save(person);
		return person;
	}

	@Override
	public void deletePersonById(Long id) {
		addbookRepo.deleteById(id);
	}

	@Override
	public List<Person> getAllPersons() {
		return addbookRepo.findAll();
	}

}
