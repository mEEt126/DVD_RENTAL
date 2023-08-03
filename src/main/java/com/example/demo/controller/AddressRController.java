package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressRController {

    @Autowired
    private AddressRepository addressRepository;

    /*
    - Gets all addresses and order by ascending
    - Para :
    - List of addresses with requested data
    */
    @RequestMapping(value = "/getAllAddress", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Address> getAllAddress()
    {
        return addressRepository.findByOrderByAddressAsc();
    }

    /*
    - Gets all addresses as requested by district name and order by district name
    - Para : district
    - List of addresses with requested data
    */
    @RequestMapping(value = "/getAllAddress/{district}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Address> getAllAddressByDistrict(@PathVariable String district)
    {
        return addressRepository.findByDistrictOrderByDistrict(district);
    }

    /*
     - Gets all addresses of given district
     - Para : district
     - List of addresses with requested data
     */
    @RequestMapping(value = "/getAllAddressByName/{district}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Address> getAllAddressByName(@PathVariable String district)
    {
        return addressRepository.retrieveByDistrictName(district);
    }

    //localhost:8080/address/getAllAddressBetweenGivenId/100&150?startId=100&endId=150
    /*
    - Gets all addresses Between requested start id and end id
    - Para : 1. StartID, 2. endId
    - List of addresses with requested data
    */
    @RequestMapping(value = "/getAllAddressBetweenGivenId/{startId}&{endId}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Address> getAllAddressBetweenGivenId(@PathVariable int startId,int endId)
    {
        return addressRepository.findByAddressIdBetween(startId, endId);
    }

    /*
    - Gets all addresses ordered by addresses in ascending order as requested by city code
    - Para : postal code
    - List of addresses with requested data
    */
    @RequestMapping(value = "/getAllAddressByPostalCodeOrderByAddress/{code}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Address> getAllAddressByPostal_code(@PathVariable String code)
    {
        return addressRepository.findByPostalCodeOrderByAddressAsc(code);
    }

    /*
    - Gets all districts and count all same cityID and return districts in ascending order
    - Para : void
    - List of addresses with requested data
    */
    @RequestMapping(value = "/getAllAddressGroupByCity&OrderByAddress", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Object[]> findByAddress()          /// Mapping requried : Specific columns needs mapping // create interface
    {
        return addressRepository.findByAddress();
    }

    /*
     - Gets top 3 addresses
     - Para : 1. StartID, 2. endId
     - List of addresses with requested data
     */
    @RequestMapping(value = "/getTop3AddressByCityId", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Address> findTop3ByCityId()
    {
        return addressRepository.findTop3ByCityId();
    }

    /*
     - Gets all addresses which contains specific pattern in district name
     - Para : 1. StartID, 2. endId
     - List of addresses with requested data
     */
    @RequestMapping(value = "/getAllAddressContaining/{str}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Address> getAddressContainingWord(@PathVariable String str)
    {
        return addressRepository.findByDistrictContaining(str);
    }

    /*
    - Gets all addresses Greater than requested city ID, group by address, district, cityID with ascending district
    - Para : cityID
    - List of addresses with requested data
    */
    @RequestMapping(value = "/getAllAddressWithCityID/{city_Id}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Object[]> getAddressWithCityID(@PathVariable int city_Id)
    {
        return addressRepository.findAllAddressGreaterThanCityId(city_Id);
    }

    /*
    - Gets all addresses Greater than requested date
    - Para : date
    - List of addresses with requested data
     */
    @RequestMapping(value = "/getAllAddressGreaterThanDate/{date}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Object[]> getAddressGreaterThanDate(@PathVariable String date) // should take date as DateTime object
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); // String to DateTime formatter
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        return addressRepository.findAllAddressGreaterThanDate(dateTime);
    }
}
