package com.jordans.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordans.productsandcategories.models.Category;
import com.jordans.productsandcategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
	//get all Products from DB utilizing built in CrudRepository extension
	List<Product> findAll();

	List<Product> findByCategoriesNotContains(Category category);
	
	List<Product> findByCategoriesContains(Category category);

}
