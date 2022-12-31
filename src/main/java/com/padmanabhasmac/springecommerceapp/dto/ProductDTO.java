package com.padmanabhasmac.springecommerceapp.dto;

import lombok.Data;

@Data
public class ProductDTO {

	private String id;

	private String name;

	private int categoryID;

	private double price;

	private double height;

	private String description;

	private String imageName;
}
