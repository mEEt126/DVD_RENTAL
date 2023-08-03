package com.example.demo.repository;

import com.example.demo.model.Address;
import com.example.demo.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {


    List<Address> findByDistrictOrderByDistrict(String district);


    @Query(value = "SELECT a FROM Address a WHERE a.addressId = :id")
    Optional<Address> findByAddressId(@Param("id") int id);


    @Query(value = "SELECT * FROM ADDRESS LIMIT 3", nativeQuery = true)
    List<Address> findTop3ByCityId();


    List<Address> findByDistrictContaining(String infix);


    @Query(value = "SELECT a FROM Address a ORDER BY a.address ASC")
    List<Address> findByOrderByAddressAsc();


    @Query(value = "SELECT a FROM Address a WHERE a.district = :district")
    List<Address> retrieveByDistrictName(@Param("district") String district);


    List<Address> findByAddressIdBetween(int startId, int endId);


    List<Address> findByPostalCodeOrderByAddressAsc(String code);


    @Query(value = "SELECT COUNT(city_id), district FROM Address  GROUP BY district ORDER BY district ASC", nativeQuery = true)
    List<Object[]> findByAddress();


    @Query(value = "SELECT COUNT(a.addressId), a.address, a.district, a.cityId " +
            "FROM Address a " +
            "GROUP BY a.address, a.district, a.cityId " +
            "HAVING a.cityId > :cityId " +
            "ORDER BY a.district ASC")
    List<Object[]> findAllAddressGreaterThanCityId(@Param("cityId") int cityId);


    @Query(value = "SELECT a.lastUpdate, a.addressId " +
            "FROM Address a " +
            "Where a.lastUpdate > :date")
    List<Object[]> findAllAddressGreaterThanDate(@Param("date") LocalDateTime date);


    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = false)
    @Query(value = "UPDATE Address a SET a.address = :address, a.address2 = :address2, a.district = :district, a.cityId = :cityId, a.postalCode = :postalCode, a.phoneNo = :phoneNo, a.lastUpdate = :lastUpdate WHERE a.addressId = :addressId")
    void update(@Param("address") String address, @Param("address2") String address2, @Param("district") String district,
                @Param("cityId") int cityId, @Param("postalCode") String postalCode, @Param("phoneNo") String phoneNo, @Param("lastUpdate") LocalDateTime lastUpdate,
                @Param("addressId") int addressId);
}
