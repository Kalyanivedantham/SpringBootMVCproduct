package com.sathya.SpringBootMVC.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.SpringBootMVC.entity.Productentity;
import com.sathya.SpringBootMVC.model.Productmodel;
import com.sathya.SpringBootMVC.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;






@Controller
public class Testcontroller {
	@Autowired
	ProductService service;
	
	@GetMapping("/test")
	public String greet() {
		return "myview";
	}
	
	
	//get the form
	@GetMapping("/productform")
	public String getProductForm(Model model)
	{
		Productmodel productmodel=new Productmodel();
		productmodel.setMadeIn("India");
		productmodel.setQuantity(100);
		productmodel.setDiscountRate(50);
		
		model.addAttribute("productmodel", productmodel);
		return "add - product";
		
	}
	//send the details to the server
	//@PostMapping("/saveproduct")
	//public String saveproduct(Productmodel productmodel)
	 //{
		//service.saveProductDetails(productmodel);
		//return "success";
	//}
	
	//validation & exception handling
	
	@PostMapping("/saveproduct")
	public String saveProduct(@Valid Productmodel productmodel, BindingResult bindingResult, Model model) {

	    HashMap<String, String> validationErrors = new HashMap<>();

	    if (bindingResult.hasErrors()) {
	        for (FieldError fieldError : bindingResult.getFieldErrors()) {
	            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	        }
	        model.addAttribute("ValidationErrors", validationErrors);
	        return "add - product";
	    }

	    service.saveProductDetails(productmodel);
	    return "redirect:/getallproducts";
	}

	
	
	@GetMapping("/getallproducts")
	public String getallproducts(Model model)
	{
		List <Productentity> productentity = service.getallproducts();
		model.addAttribute("products",productentity);
		System.out.println(productentity);
		return "productslist";
	}
	
	@GetMapping("/search")
	public String getSearchForm() {
		return "searchform";
	}
	@PostMapping("/searchbyid")
	public String searchById(@RequestParam long id,Model model) {
		Productentity product = service.searchById(id);
	    model.addAttribute("product", product);
	    
		return "searchform";
	
	}
	//delete operations
	@GetMapping("/delete/{id}")
	public String deleteProductById(@PathVariable ("id") long id) {
		service.deleteProductById(id);
		return "redirect:/getallproducts";
	}
	
	//edit operations
	@GetMapping("/edit/{id}")
	public String geteditform(@PathVariable long id, Model model)
	{
		
		 Productmodel product = service.geteditform(id);  
		  model.addAttribute("product",product);
		  model.addAttribute("id",id);
		  return "editproduct"; 
		
	}
	
	@PostMapping("/editproductsave/{id}")
	public String updateProduct(@PathVariable ("id") Long id, Productmodel productmodel) {
		
		service.updateProduct(id, productmodel);
		return "redirect:/getallproducts";
	}
	
	
	

	
}
	

