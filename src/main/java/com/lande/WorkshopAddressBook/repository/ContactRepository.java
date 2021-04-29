package com.lande.WorkshopAddressBook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lande.WorkshopAddressBook.model.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
	
	@Query(value = " select * FROM contact_details ORDER BY f_name ASC",nativeQuery = true)
		List<Contact> SortingContactAsc();

}
