package com.lande.WorkshopAddressBook.contactController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
import com.lande.WorkshopAddressBook.model.AddressData;
import com.lande.WorkshopAddressBook.service.AddressServiceInterface;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressServiceInterface Service;
	
	@GetMapping("/getall")
	public ResponseEntity<ResponseDTO> getAllAddresses() {
		List<AddressData> addressData = Service.getAllAddress();
		ResponseDTO responseDTO = new ResponseDTO("success", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> getAddressById(@PathVariable("Id") int Id) {
		AddressData addressData = Service.getAddressById(Id);
		ResponseDTO responseDTO = new ResponseDTO("success", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddresse(@RequestBody AddressDTO addressDTO) {
		AddressData addressData = Service.createAddress(addressDTO);
		ResponseDTO responseDTO = new ResponseDTO("success", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		}
		
	@PutMapping("/update/{Id}")
	public ResponseEntity<ResponseDTO> updateAddress(@PathVariable ("Id") Integer Id, @RequestBody  AddressDTO dto) {
		AddressData addressData = Service.updatedataById(Id, dto);
		ResponseDTO responseDTO = new ResponseDTO("success", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDTO> deleteAddresse(AddressData addressData) {
		ResponseDTO responseDTO = new ResponseDTO("success", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	
	

}
