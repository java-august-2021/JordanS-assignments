package com.jordans.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jordans.productsandcategories.models.Category;
import com.jordans.productsandcategories.models.Product;
import com.jordans.productsandcategories.repositories.CategoryRepo;

@Service
public class CategoryService {
	private final CategoryRepo catRepo;
	
	
	public CategoryService(CategoryRepo catRepo) {
		this.catRepo = catRepo;
	}
	
	public Category createCategory(Category category) {
		return catRepo.save(category);
	}
	
	public List<Category> allCategories(){
		return catRepo.findAll();
	}
	
	public Category findCategory(Long id) {
		Optional<Category> thisCategory = catRepo.findById(id);
		if(thisCategory.isPresent()) {
			return thisCategory.get();
		} else {
			return null;
		}
	}
	
	public Category addProduct(Category category) {
		return catRepo.save(category);
	}
	
	public List<Category> getAvailableCategoriesFor(Product product){
		return catRepo.findByProductsNotContains(product);
	}
	
	public List<Category> getUnavailableCategoriesFor(Product product){
		return catRepo.findByProductsContains(product);
	}
	
	
}
