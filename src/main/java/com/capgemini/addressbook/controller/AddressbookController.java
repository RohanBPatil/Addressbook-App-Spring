package com.capgemini.addressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.addressbook.dto.PersonDTO;
import com.capgemini.addressbook.dto.ResponseDTO;
import com.capgemini.addressbook.exception.AddressbookException;
import com.capgemini.addressbook.model.Person;
import com.capgemini.addressbook.service.IAddressbookService;

@RestController
@RequestMapping("/addressbook")
public class AddressbookController {
	@Autowired
	IAddressbookService addbookService;

	@GetMapping("/get/{personId}")
	public ResponseEntity<ResponseDTO> getPersonDataById(@PathVariable("personId") Long personId)
			throws AddressbookException {
		Person person = addbookService.getPersonById(personId);
		ResponseDTO respDTO = new ResponseDTO("Person with person Id : " + personId, person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addPerson(@Valid @RequestBody PersonDTO personDTO) throws AddressbookException {
		Person person = addbookService.addPerson(personDTO);
		ResponseDTO respDTO = new ResponseDTO("Added person : ", person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{personId}")
	public ResponseEntity<ResponseDTO> updatePerson(@PathVariable("personId") Long personId,
			@RequestBody PersonDTO personDTO) throws AddressbookException {
		Person person = addbookService.updatePersonById(personId, personDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated person : ", person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{personId}")
	public ResponseEntity<ResponseDTO> deletePersonById(@PathVariable("personId") Long personId) {
		addbookService.deletePersonById(personId);
		ResponseDTO respDTO = new ResponseDTO("Deleted the person with id : " + personId, personId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<ResponseDTO> getAllPersons() {
		List<Person> personsList = addbookService.getAllPersons();
		ResponseDTO respDTO = new ResponseDTO("Details of all persons :", personsList);
		return new ResponseEntity<>(respDTO, HttpStatus.OK);
	}
}
