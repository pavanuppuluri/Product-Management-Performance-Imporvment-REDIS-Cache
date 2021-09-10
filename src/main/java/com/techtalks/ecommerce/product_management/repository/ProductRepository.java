package com.techtalks.ecommerce.product_management.repository;

import com.techtalks.ecommerce.product_management.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByProductNameLike(String productName);
}
