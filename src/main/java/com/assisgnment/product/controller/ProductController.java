package com.assisgnment.product.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assisgnment.product.controller.*;
import com.assisgnment.product.entity.*;
import com.assisgnment.product.repository.*;
import com.assisgnment.product.service.Productservice;
/***
 * Rest Api using JPA
 * 
 * @author Gaurav Jestha
 *
 */

@RestController
@RequestMapping("/api")

public class ProductController {

	@Autowired
	private Productservice productservice;

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
//Get All Products
	@GetMapping("/products")
	public ArrayList<Entities> getAllProduct() {
		// System.out.println("Get all Products...");
		log.info("in product controller");
		return productservice.getAllProduct();
	}
//Submit Product Information
	@PostMapping(value = "/products/create")
	public Entities postProduct(@RequestBody Entities entities) {
		log.info("in create controller");
		return productservice.saveProduct(entities);

	}
//Search For Expired Products
	@GetMapping("/products/expired/")
	public List<Entities> findByExpired() {
		log.info("in expiry controller");
		return productservice.findByExpired();
	}
//Search For Non Expired Products
	@GetMapping("/products/notexpired")
	public List<Entities> findByNotExpired() {
		log.info("in non expiry controller");
		return productservice.findByNotExpired();
	}
//Search for product Expired on that Month
	@GetMapping("/products/currentmonth")
	public List<Entities> findByExpiredCurrent() {
		log.info("expiry in this month");
		return productservice.findByExpiredCurrent();
	}
//Search Product By name
	@GetMapping("/products/name/{name}")
	public List<Entities> findByName(@PathVariable String name) {
		log.info("searchbyname");
		return productservice.findByName(name);
	}
	//Search Products Between Price
	@GetMapping("/products/price/{pricemin}/{pricemax}")
	public List<Entities>SearchPrice(@PathVariable int pricemin,@PathVariable int pricemax){
		
		log.info("price between service");
		return productservice.SearchPrice(pricemin,pricemax);
		
		
	}
}
