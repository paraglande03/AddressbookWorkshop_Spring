package com.lande.WorkshopAddressBook.contactController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lande.WorkshopAddressBook.dto.ResponseDTO;
import com.lande.WorkshopAddressBook.model.AddressData;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@GetMapping("/getall")
	public ResponseEntity<ResponseDTO> getAllAddresses(AddressData addressData) {
		ResponseDTO responseDTO = new ResponseDTO("success", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
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
