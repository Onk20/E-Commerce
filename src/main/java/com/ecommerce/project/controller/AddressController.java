package com.ecommerce.project.controller;


import com.ecommerce.project.model.User;
import com.ecommerce.project.payload.AddressDTO;
import com.ecommerce.project.service.AddressService;
import com.ecommerce.project.util.AuthUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private AddressService addressService;

    @PostMapping("/addresses")
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO){

        User user = authUtil.loggedInUser();
        AddressDTO savedAddressDTO = addressService.createAddress(addressDTO, user);

        return new ResponseEntity<AddressDTO>(savedAddressDTO, HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<List<AddressDTO>> getAddress(){

        List<AddressDTO> addressDTOList = addressService.getAllAddresses();


        return new ResponseEntity<List<AddressDTO>>(addressDTOList, HttpStatus.OK);
    }

    @GetMapping("address/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long addressId){

        AddressDTO addressDTO = addressService.getAddressById(addressId);

        return new ResponseEntity<AddressDTO>(addressDTO,HttpStatus.OK);
    }

    @GetMapping("/user/address")
    public ResponseEntity<List<AddressDTO>> getAddressByUser(){

        User user = authUtil.loggedInUser();
        List<AddressDTO> addressDTOList = addressService.getAddressByUser(user);

        return new  ResponseEntity<List<AddressDTO>>(addressDTOList, HttpStatus.OK);

    }

    @PutMapping("/address/{addressId}")
    public ResponseEntity<AddressDTO> updateAddressById(@PathVariable Long addressId,
                                                        @RequestBody AddressDTO addressDTO){

        AddressDTO updatedaddressDTO = addressService.updateAddressById(addressId,addressDTO);


        return new ResponseEntity<AddressDTO>(updatedaddressDTO, HttpStatus.OK);

    }


    @DeleteMapping("/address/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId){

        String status = addressService.deleteAddressById(addressId);

        return new ResponseEntity<String>(status, HttpStatus.OK);
    }
}
