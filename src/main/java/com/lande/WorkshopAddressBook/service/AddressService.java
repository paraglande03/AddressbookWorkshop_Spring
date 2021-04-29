package com.lande.WorkshopAddressBook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Id;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.model.Address;
//import com.lande.WorkshopAddressBook.repository.AddressRepository;
import com.lande.WorkshopAddressBook.repository.AddressRepository;

import lombok.var;

@Service
public class AddressService implements AddressServiceInterface{

	@Autowired
	private AddressRepository repository;
	
	
	
	public List<Address> getAllAddress(){
		return repository.findAll();
	}

	@Override
	public Address createAddress(AddressDTO dto) {
		Address address = null;
			address =	new Address( dto);
		
		return repository.save(address);
	}

	@Override
	public Address getAddressById(UUID id) {
		return repository.findById(id).orElseThrow();
		
	}

	@Override
	public Address updatedataById(UUID Id, AddressDTO dto) {
		Address address = this.getAddressById(Id);
	
		address.setAddress(dto.address);
		address.setCity(dto.city);
		address.setState(dto.state);
		address.setZip(dto.zip);
		
		return repository.save(address);
	}

	@Override
	public void deleteDataById(UUID Id) {
		Address address = this.getAddressById(Id);
		repository.delete(address);
		
	}
	
	@Override
	public List<Address> sortAddress() {
		
		return repository.SortingAddressAsc();
		
	   
	}

	

}
