package com.padmanabhasmac.springecommerceapp.repositories;

import com.padmanabhasmac.springecommerceapp.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICategoryRepository extends MongoRepository<Category, String> {
}
