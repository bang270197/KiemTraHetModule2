package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nation")
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;

    @OneToMany(targetEntity = City.class)
    private List<City> city;

    public Nation() {
    }

    public Nation(String name, List<City> city) {
        Name = name;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
}
