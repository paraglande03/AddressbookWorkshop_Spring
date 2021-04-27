package com.lande.WorkshopAddressBook.contactController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/get/{Id}")
	public String getAddressById(@PathVariable("Id") int Id) {
		return "Get call succesful for id :"+Id;
	}
	
	@PostMapping("/create")
	public String createAddresse() {
		return "post call succesful for";
	}
		
	@PutMapping("/update")
	public String updateAddresse() {
		return "put call succesful for";
	}
	
	
	@DeleteMapping("/delete")
	public String deleteAddresse() {
		return "delete call succesful for";
	}
	
	
	

}
