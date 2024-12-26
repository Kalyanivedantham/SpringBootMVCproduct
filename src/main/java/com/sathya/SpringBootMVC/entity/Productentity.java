package com.sathya.SpringBootMVC.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="product")
public class Productentity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String brand;
	private String madeIn;
	private double price;
	private int quantity;
	@Column(name="dr")
	private int discountRate;
	private double discountPrice;
    private double taxRate;
    private double offerPrice;
    private double finalPrice;
    private double stockValue;
}
