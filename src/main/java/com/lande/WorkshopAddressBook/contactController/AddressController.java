package com.lande.WorkshopAddressBook.contactController;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.dto.ResponseDTO;
import com.lande.WorkshopAddressBook.model.Address;
import com.lande.WorkshopAddressBook.service.AddressServiceInterface;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressServiceInterface Service;
	
	@GetMapping("/all")
	public ResponseEntity<ResponseDTO> getAllAddresses() {
		List<Address> address = Service.getAllAddress();
		ResponseDTO responseDTO = new ResponseDTO("All Addresses", address);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<ResponseDTO> getAddressById(@PathVariable("Id") UUID Id) {
		Address address = Service.getAddressById(Id);
		ResponseDTO responseDTO = new ResponseDTO("success", address);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddresse(@Valid @RequestBody AddressDTO addressDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			log.info("Please enter valid information");
			ResponseDTO responseDTO = new ResponseDTO("Error in :"+bindingResult.getFieldError().getField()+bindingResult.getAllErrors().get(0).getDefaultMessage(), bindingResult.getFieldError().getDefaultMessage());
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
		}
		
			Address address = Service.createAddress(addressDTO);
			ResponseDTO responseDTO = new ResponseDTO("success", address);
			return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

		
		
		}
		
	@PutMapping("/update/{Id}")
	public ResponseEntity<ResponseDTO> updateAddress(@PathVariable ("Id") UUID Id,  @RequestBody  @Valid AddressDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			log.info("Please enter valid information");
			ResponseDTO responseDTO = new ResponseDTO("Error in :"+bindingResult.getFieldError().getField(), bindingResult.getFieldError().getDefaultMessage());
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
		}
		Address address = Service.updatedataById(Id, dto);
		ResponseDTO responseDTO = new ResponseDTO("success", address);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		}
	
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteAddresse(@PathVariable("Id") UUID Id) {
		Service.deleteDataById(Id);
		ResponseDTO responseDTO = new ResponseDTO("success :-", Id);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@GetMapping("/sort")
	public ResponseEntity<ResponseDTO> sortAddressByValue(){
		
		List<Address> address = Service.sortAddress();
		ResponseDTO responseDTO = new ResponseDTO("sorted", address);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK); 
	}
	
	

}
