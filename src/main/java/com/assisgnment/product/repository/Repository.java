package com.assisgnment.product.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.assisgnment.product.entity.*;

public interface Repository extends CrudRepository<Entities, Long> {
	@Query(value = "SELECT * FROM productinfo WHERE date < CURDATE()", nativeQuery = true)
	List<Entities> findByExpired();

	@Query(value = "SELECT * FROM productinfo WHERE date > CURDATE()", nativeQuery = true)
	List<Entities> findByNotExpired();

	@Query(value = "SELECT * FROM productinfo WHERE EXTRACT(MONTH FROM date) =EXTRACT(MONTH FROM CURDATE()) AND year(date)=year(CURDATE()) ", nativeQuery = true)
	List<Entities> findByExpiredCurrent();
	
	List<Entities> findByName(String name);
	
	@Query(value="SELECT * FROM productinfo WHERE price BETWEEN ?1 AND ?2",nativeQuery=true)
	List<Entities> SearchPrice(int pricemin,int pricemax);
	
}
