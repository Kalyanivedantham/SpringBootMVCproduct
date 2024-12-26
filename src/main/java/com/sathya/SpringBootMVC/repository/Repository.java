package com.sathya.SpringBootMVC.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sathya.SpringBootMVC.entity.Productentity;
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Productentity, Long> {

	

}
