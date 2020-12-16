package com.capgemini.addressbook.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class PersonDTO {
	@Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$", message = "Invalid first name")
	private String firstName;
	@Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$", message = "Invalid last name")
	private String lastName;
	@Pattern(regexp = "^([0-9]{1,4}[ ][0-9]{10})$", message = "Invalid contact number")
	private String contact;
	private String address;
	private String city;
	private String state;
	@Pattern(regexp = "^[0-9]{6}$", message = "Invalid zip")
	private String zip;
	
	public PersonDTO(String firstName, String lastName, String contact, String address, String city, String zip, String state) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
	};
}
