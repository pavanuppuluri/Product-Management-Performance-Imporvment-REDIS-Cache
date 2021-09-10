package com.techtalks.ecommerce.product_management.service;

import com.techtalks.ecommerce.product_management.domain.Product;
import com.techtalks.ecommerce.product_management.dtos.ProductDto;

import java.util.Optional;

public interface ProductService {
    String save(ProductDto productDto);
    Product findByProductId(Integer productId);
    public Product findByProductIdCacheByCategory(Integer productId);
    public Product findByProductIdCacheByRating(Integer productId);

    // We can have different product searches as below
    // Focussing on caching of findByProductId for now
    // List<Product> findByProductNameLike(String productName);

    public Product update(ProductDto productDto);
    public String deleteByProductId(Integer productId);
    public String deleteAll();
}
