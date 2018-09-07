package com.assisgnment.product.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assisgnment.product.entity.Entities;
import com.assisgnment.product.repository.Repository;

@Service
public class Productservice implements ProductserviceInter {
	@Autowired
	private Repository repository;
	private static final Logger log = LoggerFactory.getLogger(Productservice.class);

	@Override
	public ArrayList<Entities> getAllProduct() {

		log.info("In getAllProduct of Service Impl");
		ArrayList<Entities> products = new ArrayList<Entities>();
		repository.findAll().forEach(products::add);
		return products;
	}

	@Override
	public Entities saveProduct(Entities entities) {

		Entities entiti = repository.save(entities);
		return entiti;
	}

	@Override
	public List<Entities> findByExpired() {
		log.info("In findbyexpired service");

		return repository.findByExpired();

	}

	@Override
	public List<Entities> findByNotExpired() {
		log.info("In findbynot expired service");

		return repository.findByNotExpired();
	}

	@Override
	public List<Entities> findByExpiredCurrent() {
		log.info("In current month expired");
		return repository.findByExpiredCurrent();
	}

	@Override
	public List<Entities> findByName(String name) {
		log.info("In service name");
		return repository.findByName(name);
	}
	@Override
	public List<Entities> SearchPrice(int pricemin,int pricemax){
		log.info("in service price");
		return repository.SearchPrice(pricemin,pricemax);
	}
	
	
}
