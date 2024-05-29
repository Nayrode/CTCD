package org.ghuh.ctcd.entities;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "department_code", nullable = false)
    @JsonAlias("department_code")
    private String departmentCode;

    @Column(name = "insee_code")
    @JsonAlias("insee_code")
    private String inseeCode;

    @Column(name = "zip_code")
    @JsonAlias("zip_code")
    private String zipCode;

    @Column(name = "name", nullable=false)
    private String name;

    @Column(nullable = false)
    private float lat;

    @Column(nullable = false)
    private float lon;

    public City() {
    }

    public City(String departmentCode, String inseeCode, String zipCode, String name, float lat, float lon) {
        this.departmentCode = departmentCode;
        this.inseeCode = inseeCode;
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }
    
    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getInseeCode() {
        return inseeCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public void setInseeCode(String inseeCode) {
        this.inseeCode = inseeCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }
}
