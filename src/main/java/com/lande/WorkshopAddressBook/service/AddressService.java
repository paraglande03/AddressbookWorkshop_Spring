package com.lande.WorkshopAddressBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lande.WorkshopAddressBook.model.AddressData;

@Service
public class AddressService {
	
	List<AddressData> list = new ArrayList<>();
	
	public List<AddressData> getAllAddress(){
		return list;
	}

}
