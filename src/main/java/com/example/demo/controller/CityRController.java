package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityRController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "/getAllCityName", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<City> getAllCityName()
    {
        return cityRepository.findAll();
    }

    @RequestMapping(value = "/getCityByName/{city}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public Optional<City> getCity(@PathVariable String city)
    {
        return cityRepository.findByCity(city);
    }


    @RequestMapping(value = "/getAllCityByCountryId/{countryId}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<City> getAllCityByCountryId(@PathVariable int countryId)
    {
        return cityRepository.findByCountryId(countryId);
    }

    @RequestMapping(value = "/getCityByCountry", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<City> getAllCityByCountry(@RequestBody Country country)
    {
        return cityRepository.findByCountry(country);
    }

    @RequestMapping(value = "/getCityNameWithCountryName", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Object[]> getFullAddress()
    {
        return cityRepository.findFullAddress();
    }
}
