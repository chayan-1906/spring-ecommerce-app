package com.padmanabhasmac.springecommerceapp.repositories;

import com.padmanabhasmac.springecommerceapp.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IProductRepository extends MongoRepository<Product, String> {
	List<Product> findAllByCategory_Id(String categoryID);
}
