package com.sathya.SpringBootMVC.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productmodel {
	@NotBlank(message="product name cannot be blank")
	private String name;
	@NotBlank(message="product name cannot be blank")
	private String brand;
	@NotBlank(message="MadeIn field cannot be blank")
	private String madeIn;
	@Positive(message="pricew must be greater than zero")
	private double price;
	@Min(value=1,message="quantity must be atleast 1")
	private int quantity;
	@DecimalMax(value="100", message="discount rate cannot be exceed 100")
	private int discountRate;
	
}
