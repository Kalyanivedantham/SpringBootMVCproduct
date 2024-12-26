package com.sathya.SpringBootMVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sathya.SpringBootMVC.entity.Productentity;
import com.sathya.SpringBootMVC.model.Productmodel;
import com.sathya.SpringBootMVC.repository.Repository;


@org.springframework.stereotype.Service
public class ProductService 
{
 
@Autowired
  Repository repository;


  public void saveProductDetails(Productmodel productmodel)
  {
	  double stockValue;
	  stockValue=productmodel.getPrice()*productmodel.getQuantity();
	  
	  double discountPrice;
	  discountPrice=productmodel.getPrice()*productmodel.getDiscountRate()/100;
	  
	  double offerPrice;
	  offerPrice=productmodel.getPrice()-discountPrice;
	 
	  
	  double taxPrice;
	  double taxRate=17;
	  taxPrice=offerPrice*taxRate/100;
      
	  double finalPrice;
	  finalPrice=offerPrice +taxPrice;
	  
	  Productentity productentity=new Productentity();
	  
	  productentity.setName(productmodel.getName());
	  productentity.setBrand(productmodel.getBrand());
	  productentity.setMadeIn(productmodel.getMadeIn());
	  productentity.setPrice(productmodel.getPrice());
	  productentity.setQuantity(productmodel.getQuantity());
	  productentity.setDiscountRate(productmodel.getDiscountRate());
	  
	  productentity.setStockValue(stockValue);
      productentity.setDiscountPrice(discountPrice);
      productentity.setOfferPrice(offerPrice);
      productentity.setTaxRate(taxPrice);
      productentity.setFinalPrice(finalPrice);
	  
      repository.save(productentity);
      
}
public List<Productentity> getallproducts() {
	List<Productentity> products= repository.findAll();
	return products;
}
 public  Productentity searchById(Long id) {
	Optional<Productentity> optionalData= repository.findById(id);
	if(optionalData.isPresent())
			{
		        Productentity product = optionalData.get();
		        return product;
			}
	else {
		return null;
	}
}
public void deleteProductById(Long id) {
	repository.deleteById(id);
	
}
public Productmodel updateProduct(Long id, Productmodel productmodel) {
	
	Optional<Productentity> optionalData= repository.findById(id);
	if(optionalData.isPresent())
	{
		Productentity productentity= optionalData.get();
		
		  double stockValue;
		  stockValue=productmodel.getPrice()*productmodel.getQuantity();
		  
		  double discountPrice;
		  discountPrice=productmodel.getPrice()*productmodel.getDiscountRate()/100;
		  
		  double offerPrice;
		  offerPrice=productmodel.getPrice()-discountPrice;
		 
		  
		  double taxPrice;
		  double taxRate=17;
		  taxPrice=offerPrice*taxRate/100;
	      
		  double finalPrice;
		  finalPrice=offerPrice +taxPrice;
		
		
		
            productentity.setName(productmodel.getName());
            productentity.setBrand(productmodel.getBrand());
            productentity.setPrice(productmodel.getPrice());
            productentity.setMadeIn(productmodel.getMadeIn());
            productentity.setQuantity(productmodel.getQuantity());
            productentity.setDiscountRate(productmodel.getDiscountRate());
            
            
            productentity.setStockValue(stockValue);
            productentity.setDiscountPrice(discountPrice);
            productentity.setOfferPrice(offerPrice);
            productentity.setTaxRate(taxPrice);
            productentity.setFinalPrice(finalPrice);
            
            repository.save(productentity);
		
		    return productmodel;
		
	}
	else
	{
		return null;
	}
		
}


public Productmodel geteditform(Long id) {
	Optional<Productentity> optionalData= repository.findById(id);
	if(optionalData.isPresent())
	{
		Productentity productentity= optionalData.get();
		Productmodel productmodel=new Productmodel();
		productmodel.setName(productentity.getName());
        productmodel.setBrand(productentity.getBrand());
        productmodel.setPrice(productentity.getPrice());
        productmodel.setMadeIn(productentity.getMadeIn());
        productmodel.setQuantity(productentity.getQuantity());
        productmodel.setDiscountRate(productentity.getDiscountRate());
		
		
		return productmodel;
		
	}
	else
	{
		return null;
	}

}
}