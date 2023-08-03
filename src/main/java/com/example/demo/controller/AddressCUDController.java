package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressCUDController {

    @Autowired
    private AddressRepository addressRepository;

    /*
    - Create a address as per given details
    - Para : all fields
    - Response Entity with required Status code
     */
    @RequestMapping(value = "/createNewAddress", method = RequestMethod.POST, produces ="application/json", consumes = "application/json")
    public ResponseEntity<Address> addAddress(@RequestBody Address address)
    {
        Address address1 = addressRepository.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(address1);
    }

    /*
    @RequestMapping(value = "/createNewAllAddress", method = RequestMethod.POST, produces ="application/json", consumes = "application/json")
    public void addAlLAddress(@RequestBody List<Address> allAddress)
    {
        addressRepository.saveAll(allAddress);
    }*/

    /*
    - Update a address as per requested Address Id
    - Para : address ID
    - List of addresses with requested data
     */
    /*
     - Gets all addresses whose address id is requested
     - Para : 1. address ID
     - List of addresses with requested data
    */
    @RequestMapping(value = "/updateAddress", method = RequestMethod.PUT, produces ="application/json", consumes = "application/json")
    public ResponseEntity<String> UpdateAddress(@RequestBody Address address) {
        Optional<Address> address1 = addressRepository.findByAddressId(address.getAddressId());
        if (address1.isPresent())
        {
            addressRepository.update(address.getAddress(), address.getAddress2(), address.getDistrict(), address.getCityId(),
                    address.getPostalCode(), address.getPhoneNo(), address.getLastUpdate(), address.getAddressId());
        return ResponseEntity.status(HttpStatus.CREATED).body("request accepted, User Updated");
        }
        else {
            // throw exception or save
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    /*
     - Deletes a address whose address id is requested
     - Para : 1. address ID
     - List of addresses with requested data
    */
    @RequestMapping(value = "/deleteAddress/{addressId}", method = RequestMethod.DELETE, produces ="application/json", consumes = "application/json")
    public ResponseEntity<String> deleteAddress(@PathVariable int addressId) {
        Optional<Address> address = addressRepository.findByAddressId(addressId);
        if (address.isPresent())
        {
            addressRepository.deleteById(addressId);
            return ResponseEntity.ok().body("Address Removed");
        }
        else
        {
            return ResponseEntity.badRequest().body("Address Not Found");
        }
    }
}
