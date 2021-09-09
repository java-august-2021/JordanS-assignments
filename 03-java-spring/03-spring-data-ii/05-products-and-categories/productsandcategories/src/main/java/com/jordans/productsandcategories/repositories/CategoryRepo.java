package com.jordans.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordans.productsandcategories.models.Category;
import com.jordans.productsandcategories.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>{
	//list all Categories utilizing builtin CrudRepository
	List<Category> findAll();
	
	List<Category> findByProductsNotContains(Product product);
	
	List<Category> findByProductsContains(Product product);
}
