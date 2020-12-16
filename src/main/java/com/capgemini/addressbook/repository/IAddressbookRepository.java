package com.capgemini.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.addressbook.model.Person;

public interface IAddressbookRepository extends JpaRepository<Person, Long>{

}
