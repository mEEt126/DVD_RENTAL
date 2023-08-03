package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_country_id_seq")
    @SequenceGenerator(name = "country_country_id_seq", sequenceName = "country_country_id_seq", allocationSize = 1)
    @Column(name = "country_id", nullable = false)
    private int country_id;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "country")
    private List<City> cityList;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime last_update;

    public Country() {
    }

    public Country(int country_id, List<City> cityList, String country, LocalDateTime lastUpdate) {
        this.country_id = country_id;
        this.cityList = cityList;
        this.country = country;
        this.last_update = lastUpdate;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return last_update;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.last_update = lastUpdate;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_id=" + country_id +
                ", country='" + country + '\'' +
                ", lastUpdate=" + last_update +
                '}';
    }
}
