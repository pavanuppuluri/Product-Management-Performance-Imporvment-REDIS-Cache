package com.techtalks.ecommerce.product_management.service.impl;

import com.techtalks.ecommerce.product_management.domain.Product;
import com.techtalks.ecommerce.product_management.dtos.ProductDto;
import com.techtalks.ecommerce.product_management.mappers.ProductDtoToProductMapper;
import com.techtalks.ecommerce.product_management.repository.ProductRepository;
import com.techtalks.ecommerce.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductDtoToProductMapper productDtoToProductMapper;

    @Override
    public String save(ProductDto productDto) {
        Product product=productDtoToProductMapper.mapProductDtoToProduct(productDto);
        productRepository.save(product);
        return "PRODUCT_CREATED";
    }

    // Below Cacheable annotation caches the result
    // @Cacheable(value = "productsCache")
    // Problem with this is, even a product with given ID not found then
    // also, it caches the result with value=null
    // But if we want to cache only when Product is found, then
    // we can use @Cacheble with unless property
    // @Cacheable(value = "productsCache", unless="#result == null")

    @Override
    @Cacheable(value = "productsCache", unless="#result == null")
    public Product findByProductId(Integer productId) {
        System.out.println("Inside findByProductId");
        return productRepository.findById(productId).get();
    }

    // Conditional caching
    // Only cache product from Electronics category
    @Override
    @Cacheable(value = "productsCache", unless="#result.productCategory != \"Electronics\"")
    public Product findByProductIdCacheByCategory(Integer productId) {
        System.out.println("Inside findByProductId");
        return productRepository.findById(productId).get();
    }

    // Only cache product with rating >=4
    @Override
    @Cacheable(value = "productsCache", unless="#result.productCategory != \"Electronics\"")
    public Product findByProductIdCacheByRating(Integer productId) {
        System.out.println("Inside findByProductId");
        return productRepository.findById(productId).get();
    }


    @Override
    @CacheEvict(value = "productsCache", key = "#productId")
    public String deleteByProductId(Integer productId)
    {
        productRepository.deleteById(productId);
        return "PRODUCT_DELETED";
    }

    @Override
    @CacheEvict(value = "productsCache", allEntries = true)
    public String deleteAll()
    {
        productRepository.deleteAll();
        return "ALL_PRODUCTS_DELETED";
    }

    @Override
    @CachePut(value = "productsCache", key = "#productDto.productId")
    public Product update(ProductDto productDto) {
        Product product=productDtoToProductMapper.mapProductDtoToProduct(productDto);
        Product existingProduct=productRepository.findById(productDto.getProductId()).get();

        productRepository.save(product);
        return product;
    }



//    @Override
//    public List<Product> findByProductNameLike(String productName) {
//        return productRepository.findByProductNameLike(productName);
//    }
}
