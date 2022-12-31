package com.padmanabhasmac.springecommerceapp.services;

import com.padmanabhasmac.springecommerceapp.models.Category;
import com.padmanabhasmac.springecommerceapp.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		return categoryRepository.findAll ( );
	}

	public void addCategory(Category category) {
		categoryRepository.save ( category );
	}

}
