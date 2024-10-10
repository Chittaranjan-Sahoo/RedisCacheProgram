package com.crs.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crs.www.entity.Product;
import com.crs.www.service.IproductService;

@RestController
@RequestMapping("/product-api")
public class ProductController {
	@Autowired
	private IproductService productservice;

	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody Product prod)
	{
		Product saveproduct=productservice.addProduct(prod);
		return new ResponseEntity<String>(saveproduct.toString()+"is saved",HttpStatus.CREATED);
	}
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Product> findProductByid(@PathVariable int id)
	{
		Product prod=productservice.findProductById(id);
		return new ResponseEntity<>(prod,HttpStatus.OK);
	}
	@GetMapping("/get")
	public ResponseEntity<List<Product>> getAllProduct()
	{
		List<Product> list=productservice.showAllProduct();
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id)
	{
		String msg=productservice.deleteProduct(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
