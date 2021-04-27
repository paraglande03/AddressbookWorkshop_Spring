package com.lande.WorkshopAddressBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.model.AddressData;
//import com.lande.WorkshopAddressBook.repository.AddressRepository;

@Service
public class AddressService implements AddressServiceInterface{

	
	List<AddressData> list = new ArrayList<>();
	
	public List<AddressData> getAllAddress(){
		return list;
	}

	@Override
	public AddressData createAddress(AddressDTO dto) {
		AddressData addressData = new AddressData(list.size()+1, dto);
		list.add(addressData);
		return addressData;
	}

	@Override
	public AddressData getAddressById(int id) {
		
		return list.stream().filter(addData-> addData.getId()==id).findFirst().orElseThrow();
	}

	

}
