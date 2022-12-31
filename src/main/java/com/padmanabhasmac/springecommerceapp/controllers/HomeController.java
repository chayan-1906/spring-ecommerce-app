package com.padmanabhasmac.springecommerceapp.controllers;

import com.padmanabhasmac.springecommerceapp.models.Product;
import com.padmanabhasmac.springecommerceapp.repositories.ICategoryRepository;
import com.padmanabhasmac.springecommerceapp.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private IProductRepository productRepository;

	@GetMapping({"/", "/home"})
	public String home(Model model) {
		return "index";
	}

	@GetMapping("/shop")
	public String shop(Model model) { //?? RETURN TYPE IS SUPPOSED TO BE LIST<CATEGORY>
		model.addAttribute ( "categories", categoryRepository.findAll ( ) );
		model.addAttribute ( "products", productRepository.findAll ( ) );
		return "shop";
	}

	/// same as AdminController.java getAllProductsByCategoryId() method
	@GetMapping("/shop/category/{categoryID}")
	public List<Product> shopByCategory(@PathVariable String categoryID) {
		return productRepository.findAllByCategory_Id ( categoryID );
	}

	/// same as AdminController.java getProductById() method
	@GetMapping("/shop/category/{productID}")
	public Optional<Product> getProductByID(@PathVariable String productID) {
		return productRepository.findById ( productID );
	}
}
