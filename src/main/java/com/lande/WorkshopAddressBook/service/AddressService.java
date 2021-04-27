package com.lande.WorkshopAddressBook.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.model.AddressData;
//import com.lande.WorkshopAddressBook.repository.AddressRepository;
import com.lande.WorkshopAddressBook.repository.AddressRepository;

@Service
public class AddressService implements AddressServiceInterface{

	@Autowired
	private AddressRepository repository;
	
	
	
	public List<AddressData> getAllAddress(){
		return repository.findAll();
	}

	@Override
	public AddressData createAddress(AddressDTO dto) {
		AddressData addressData = null;
			addressData =	new AddressData( dto);
		
		return repository.save(addressData);
	}

	@Override
	public AddressData getAddressById(int id) {
		return repository.findById(id).orElseThrow();
		
	}

	@Override
	public AddressData updatedataById(int Id, AddressDTO dto) {
		AddressData addressData = this.getAddressById(Id);
	
		addressData.setAddress(dto.address);
		addressData.setCity(dto.city);
		addressData.setState(dto.state);
		addressData.setZip(dto.zip);
		
		return repository.save(addressData);
	}

	@Override
	public void deleteDataById(int Id) {
		list.remove(Id-1);
		
	}

	

}
