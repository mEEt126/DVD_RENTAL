package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryRController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = "/getAllCountryName", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<Country> getAllCountryName()
    {
        return countryRepository.findAll();
    }

    @RequestMapping(value = "/getAllCityByCountryName/{country_name}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<City> getAllCityNames(@PathVariable String country_name)
    {
        return countryRepository.findByCountry(country_name);
    }

    @RequestMapping(value = "/getCountryName/{country_id}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String getCountryName(@PathVariable int country_id)
    {
        return countryRepository.getCountryName(country_id);
    }
}
