package com.crs.www.service;

import java.util.List;

import com.crs.www.entity.Product;

public interface IproductService {
	
	public Product addProduct(Product product);
	public List<Product> showAllProduct();
	public String deleteProduct(int pid);
	public Product findProductById(int pid);

}
