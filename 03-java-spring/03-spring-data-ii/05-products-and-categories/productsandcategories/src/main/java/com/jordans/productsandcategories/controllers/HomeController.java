package com.jordans.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jordans.productsandcategories.models.Category;
import com.jordans.productsandcategories.models.Product;
import com.jordans.productsandcategories.services.CategoryService;
import com.jordans.productsandcategories.services.ProductService;

@Controller
public class HomeController {
	private final CategoryService catService;
	private final ProductService prodService;
	
	public HomeController(CategoryService catServ, ProductService prodServ) {
		this.catService = catServ;
		this.prodService = prodServ;
	}
	
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/products/new";
	}
	
	@RequestMapping("/products/new")
	public String index(@ModelAttribute("product") Product product, Model model) {
		List<Product> products = prodService.allProducts();
		model.addAttribute("products", products);
		return "index.jsp";
	}
	
	@RequestMapping("/products/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			prodService.createProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product thisProduct = prodService.findProduct(id);
		model.addAttribute("product", thisProduct);
		model.addAttribute("unaffiliatedCategories", catService.getAvailableCategoriesFor(thisProduct));
		model.addAttribute("affiliatedCategories", catService.getUnavailableCategoriesFor(thisProduct));
		return "product.jsp";
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {
		List<Category> categories = catService.allCategories();
		model.addAttribute("categories", categories);
		return "category.jsp";
	}
	
	@RequestMapping(value = "/categories/create", method = RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			catService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category thisCategory = catService.findCategory(id);
		model.addAttribute("category", thisCategory);
		model.addAttribute("unaffiliatedProducts", prodService.getAvailableProductsFor(thisCategory));
		model.addAttribute("affiliatedProducts", prodService.getUnavailableProductsFor(thisCategory));
		return "displayCategory.jsp";
	}
	
	@RequestMapping(value = "/categories/{catId}/addproduct", method = RequestMethod.POST)
	public String addProductToCategory(@PathVariable("catId") Long catId, @RequestParam(value = "prodId") Long prodId, Model model) {
		Category thisCategory = catService.findCategory(catId);
		Product thisProduct = prodService.findProduct(prodId);
		thisCategory.getProducts().add(thisProduct);
		catService.addProduct(thisCategory);
		return "redirect:/categories/{catId}";
	}
	
	@RequestMapping(value = "/products/{prodId}/addcategory", method = RequestMethod.POST)
	public String addCategoryToProduct(@PathVariable("prodId") Long prodId, @RequestParam(value = "catId") Long catId, Model model) {
		Product thisProduct = prodService.findProduct(prodId);
		Category thisCategory = catService.findCategory(catId);
		thisProduct.getCategories().add(thisCategory);
		prodService.addCategory(thisProduct);
		return "redirect:/products/{prodId}";
	}
}
