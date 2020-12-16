package com.capgemini.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capgemini.addressbook.dto.PersonDTO;

import lombok.Data;

@Entity
@Table(name = "person")
public @Data class Person {
	@Id
	private long id;
	private String firstName;
	private String lastName;
	private String contact;
	private String address;
	private String city;
	private String state;
	private String zip;

	public Person() {

	}

	public Person(PersonDTO personDTO) {
		this.firstName = personDTO.getFirstName();
		this.lastName = personDTO.getLastName();
		this.contact = personDTO.getContact();
		this.address = personDTO.getAddress();
		this.city = personDTO.getCity();
		this.state = personDTO.getState();
		this.zip = personDTO.getZip();
	}

	public Person(long id, PersonDTO personDTO) {
		this(personDTO);
		this.id = id;
	}
}
