package com.lande.WorkshopAddressBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lande.WorkshopAddressBook.model.AddressData;
import com.lande.WorkshopAddressBook.model.ContactData;

public interface ContactRepository extends JpaRepository<ContactData,Integer> {

}
