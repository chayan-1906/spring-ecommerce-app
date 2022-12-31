package com.padmanabhasmac.springecommerceapp.controllers;

import com.padmanabhasmac.springecommerceapp.models.Category;
import com.padmanabhasmac.springecommerceapp.models.Product;
import com.padmanabhasmac.springecommerceapp.repositories.ICategoryRepository;
import com.padmanabhasmac.springecommerceapp.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

	/// Category Section
	/* Thymeleaf
	@Autowired
	private CategoryService categoryService;*/

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private IProductRepository productRepository;

	@GetMapping
	public String adminHome() {
		return "adminHome";
	}

	/* Thymeleaf
	@GetMapping("/categories")
	public String getCategories(Model model) {
		model.addAttribute ( "categories", categoryService.getAllCategories ( ) );
		return "categories";
	}*/

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryRepository.findAll ( );
	}

	/* Thymeleaf
	@GetMapping("/categories/add")
	public String getCategoryAdd(Model model) {
		model.addAttribute ( "category", new Category ( ) );
		return "categoriesAdd";
	}*/

	/*Thymeleaf
	@PostMapping("/categories/add")
	public String addCategory(@ModelAttribute("category") Category category) {
		categoryService.addCategory ( category );
		System.out.println ( categoryService.getAllCategories ( ) );
		return "redirect:/admin/categories";
	}*/

	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		categoryRepository.save ( category );
		System.out.println ( categoryRepository.findAll ( ) );
		return category;
	}

	@PutMapping("/categories/{categoryID}")
	public Category updateCategory(@PathVariable String categoryID, @RequestBody Category categoryRequest) {
		Category categoryToBeUpdated = categoryRepository.findById ( categoryID ).get ( );
		categoryToBeUpdated.setId ( categoryID );
		categoryToBeUpdated.setName ( categoryRequest.getName ( ) );
		return categoryRepository.save ( categoryToBeUpdated );
	}

	@DeleteMapping("/categories/{categoryID}")
	public String deleteCategory(@PathVariable String categoryID) {
		Category categoryToBeDeleted = categoryRepository.findById ( categoryID ).get ( );
		categoryRepository.deleteById ( categoryID );
		return categoryToBeDeleted.getName ( ) + " deleted successfully";
	}

	/// Product Section

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productRepository.findAll ( );
	}

	@GetMapping("/products/{productID}")
	public Optional<Product> getProductById(@PathVariable String productID) {
		return productRepository.findById ( productID );
	}

	@GetMapping("/products/category/{categoryID}")
	public List<Product> getAllProductsByCategoryId(@PathVariable String categoryID) {
		return productRepository.findAllByCategory_Id ( categoryID );
	}

	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		productRepository.save ( product );
		System.out.println ( productRepository.findAll ( ) );
		return product;
	}

	@PutMapping("/products/{productID}")
	public Product updateProduct(@PathVariable String productID, @RequestBody Product productRequest) {
		Product productToBeUpdated = productRepository.findById ( productID ).get ( );
		productToBeUpdated.setId ( productID );
		productToBeUpdated.setCategory ( productRequest.getCategory ( ) );
		productToBeUpdated.setPrice ( productRequest.getPrice ( ) );
		productToBeUpdated.setWeight ( productRequest.getWeight ( ) );
		productToBeUpdated.setDescription ( productRequest.getDescription ( ) );
		productRepository.save ( productToBeUpdated );
		return productToBeUpdated;
	}

	@DeleteMapping("/products/{productID}")
	public String deleteProduct(@PathVariable String productID) {
		Product productToBeDeleted = productRepository.findById ( productID ).get ( );
		productRepository.deleteById ( productID );
		return productToBeDeleted.getName ( ) + " deleted successfully";
	}
}
