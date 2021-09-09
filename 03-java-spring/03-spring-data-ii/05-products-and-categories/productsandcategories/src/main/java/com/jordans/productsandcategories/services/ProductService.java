package com.jordans.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jordans.productsandcategories.models.Category;
import com.jordans.productsandcategories.models.Product;
import com.jordans.productsandcategories.repositories.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo prodRepo;
	
	public ProductService(ProductRepo prodRepo) {
		this.prodRepo = prodRepo;
	}
	
	public Product createProduct(Product product) {
		return prodRepo.save(product);
	}
	
	public List<Product> allProducts(){
		return prodRepo.findAll();
	}
	
	public Product findProduct(Long id) {
		Optional<Product> thisProduct = prodRepo.findById(id);
		if(thisProduct.isPresent()) {
			return thisProduct.get();
		} else {
			return null;
		}
	}
	
	public Product addCategory(Product product) {
		return prodRepo.save(product);
	}
	
	public List<Product> getAvailableProductsFor(Category category){
		return prodRepo.findByCategoriesNotContains(category);
	}
	
	public List<Product> getUnavailableProductsFor(Category category){
		return prodRepo.findByCategoriesContains(category);
	}

}
