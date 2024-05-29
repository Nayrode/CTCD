package org.ghuh.ctcd.interfaces;

import org.ghuh.ctcd.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
}
