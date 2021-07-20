package com.mhdgp.springweb.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mhdgp.springweb.repos.ProductRepository;
import com.mhdgp.springweb.entities.*;

@RestController
public class ProductRestController {

	@Autowired
	ProductRepository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);
	
	
	
	//get all poducts
	@RequestMapping(value="/products/", method = RequestMethod.GET)
	public List<Product> getProducts(){
			return repository.findAll();
		}
	
	//get one product by id
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		LOGGER.info("Finding product by Id: "+ id);
		return repository.findById(id).get();
	}
	
	//create new product
	@RequestMapping(value = "/products/", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	//update product
		@RequestMapping(value = "/products/", method = RequestMethod.PUT)
		public Product updateProduct(@RequestBody Product product) {
			return repository.save(product);
		}
		
		//delete product by id
		@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
		public void deleteProduct(@PathVariable("id") int id) {
			 repository.deleteById(id);
		}
	
}
