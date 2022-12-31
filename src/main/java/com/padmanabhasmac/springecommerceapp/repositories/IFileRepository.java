package com.padmanabhasmac.springecommerceapp.repositories;

import com.padmanabhasmac.springecommerceapp.models.FileModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IFileRepository extends MongoRepository<FileModel, String> {
}
