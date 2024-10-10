package com.crs.www.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.crs.www.entity.Product;
import com.crs.www.repo.ProductRepository;
@Service
public class ProductServiceImpl implements IproductService {

	@Autowired
	private ProductRepository productrepo;
	@CachePut(value="prods",key="#product.pid")
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productrepo.save(product);
		
	}

	@Cacheable(value="prods")
	@Override
	public List<Product> showAllProduct() {
		// TODO Auto-generated method stub
		return productrepo.findAll();
	}

	@CacheEvict(value="prods",key="#pid")
	@Override
	public String deleteProduct(int pid) {
		// TODO Auto-generated method stub
		Optional<Product> opt=productrepo.findById(pid);
		if(opt.isPresent())
		{
		return "Product deleted";
		}
		return "product is not found for deletion";
	}

	@Cacheable(value="prods",key="#pid")
	@Override
	public Product findProductById(int pid) {
		// TODO Auto-generated method stub
		return productrepo.findById(pid).orElseThrow(()->new IllegalArgumentException("Invalid product id"));
	}

}
