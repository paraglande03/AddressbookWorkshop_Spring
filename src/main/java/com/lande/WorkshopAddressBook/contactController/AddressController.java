package com.lande.WorkshopAddressBook.contactController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@GetMapping("/getall")
	public String getAllAddresses() {
		return "Get call succesful for all addresses";
	}
	
	@PostMapping("/create")
	public String createAddresse() {
		return "put call succesful for";
	}
		
	@PutMapping("/update")
	public String updateAddresse() {
		return "put call succesful for";
	}
	
	
	

}
