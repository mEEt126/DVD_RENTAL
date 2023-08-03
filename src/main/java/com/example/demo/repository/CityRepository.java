package com.example.demo.repository;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value = "SELECT c FROM City c WHERE c.city = :city")
    Optional<City> findByCity(@Param("city") String city);

    List<City> findByCountry(Country country);

    @Query(value = "SELECT a.city_id,b.country_id, a.city, b.country " +
            "FROM city a " +
            "LEFT JOIN country b " +
            "ON a.country_id = b.country_id", nativeQuery = true)
    List<Object[]> findFullAddress();

    @Query(value = "SELECT c FROM City c JOIN c.country a WHERE a.country_id = :country_id")
    List<City> findByCountryId(@Param("country_id") int country_id);
}
