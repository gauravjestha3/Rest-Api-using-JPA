package com.assisgnment.product.service;

import java.util.ArrayList;
import java.util.List;

import com.assisgnment.product.entity.Entities;

public interface ProductserviceInter
{
	public ArrayList<Entities> getAllProduct();

	public Entities saveProduct(Entities entities);

	public List<Entities> findByExpired();

	public List<Entities> findByNotExpired();

	public List<Entities>findByExpiredCurrent();
	
	public List<Entities>findByName(String name);
	
	public List<Entities>SearchPrice(int pricemin,int pricemax);
}
