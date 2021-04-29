package com.lande.WorkshopAddressBook.contactController;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.dto.ContactDTO;
import com.lande.WorkshopAddressBook.dto.ResponseDTO;
import com.lande.WorkshopAddressBook.model.Address;
import com.lande.WorkshopAddressBook.model.Contact;
import com.lande.WorkshopAddressBook.service.ContactServiceInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private	ContactServiceInterface Service;
	
	@GetMapping("/all")
	public ResponseEntity<ResponseDTO> getAllContacts() {
		List<Contact> contact = Service.getAllContacts();
		ResponseDTO responseDTO = new ResponseDTO("success", contact);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}

	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable("Id") UUID Id) {
		Contact contact = Service.getContactById(Id);
		ResponseDTO responseDTO = new ResponseDTO("success", contact);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createContact(@RequestBody @Valid ContactDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			log.info("Please enter valid information");
			ResponseDTO responseDTO = new ResponseDTO("Error in :"+bindingResult.getFieldError().getField(), bindingResult.getFieldError().getDefaultMessage());
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
		}
		
		Contact contact = Service.createContact(dto);
		ResponseDTO responseDTO = new ResponseDTO("success", contact);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<ResponseDTO> updateContact(@PathVariable ("Id") UUID Id, @RequestBody @Valid ContactDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			log.info("Please enter valid information");
			ResponseDTO responseDTO = new ResponseDTO("Error in :"+bindingResult.getFieldError().getField(), bindingResult.getFieldError().getDefaultMessage());
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
		}
		
		Contact contact = Service.updatedataById(Id, dto);
		ResponseDTO responseDTO = new ResponseDTO("success", contact);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("Id") UUID Id) {
		Service.deleteDataById(Id);
		ResponseDTO responseDTO = new ResponseDTO("success :-", Id);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@GetMapping("/sort")
	public ResponseEntity<ResponseDTO> sortContactByValue(){
		
		List<Contact> contact = Service.sortContact();
		ResponseDTO responseDTO = new ResponseDTO("sorted", contact);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK); 
	}
	
}
