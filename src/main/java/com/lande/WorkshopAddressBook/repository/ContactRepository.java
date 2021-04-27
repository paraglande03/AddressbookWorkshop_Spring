package com.lande.WorkshopAddressBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lande.WorkshopAddressBook.model.AddressData;

public interface ContactRepository extends JpaRepository<AddressData,Integer> {

}
