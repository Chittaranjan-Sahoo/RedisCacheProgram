package com.crs.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crs.www.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
