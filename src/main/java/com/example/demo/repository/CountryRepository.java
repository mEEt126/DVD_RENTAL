package com.example.demo.repository;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "SELECT c.cityList FROM Country c WHERE c.country = :country_name")
    List<City> findByCountry(@Param("country_name") String country_name);

    @Query(value = "SELECT c.country FROM Country c WHERE c.country_id = :country_id")
    String getCountryName(@Param("country_id") int country_id);
}
