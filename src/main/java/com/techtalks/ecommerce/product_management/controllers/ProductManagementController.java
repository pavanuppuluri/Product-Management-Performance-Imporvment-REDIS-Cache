package com.techtalks.ecommerce.product_management.controllers;

import com.techtalks.ecommerce.product_management.domain.Product;
import com.techtalks.ecommerce.product_management.domain.ProductRatingSummary;
import com.techtalks.ecommerce.product_management.dtos.ProductDto;
import com.techtalks.ecommerce.product_management.dtos.ProductRatingDto;
import com.techtalks.ecommerce.product_management.service.ProductRatingService;
import com.techtalks.ecommerce.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductManagementController {

    @Autowired
    ProductRatingService productRatingService;

    @Autowired
    ProductService productService;



    @GetMapping("/getproductinfo")
    public ResponseEntity<Product> getProductInfo(@RequestParam Integer productId)
    {
        Product product = productService.findByProductId(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);


    }

    @PostMapping("/createproduct")
    public String createProduct(@RequestBody ProductDto productDto)
    {
        String status = productService.save(productDto);
        return status;
    }

    @PutMapping("/updateproduct")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto productDto)
    {
        Product updatedProduct = productService.update(productDto);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/deleteproduct")
    public String deleteProduct(@RequestParam Integer productId)
    {
        String status = productService.deleteByProductId(productId);
        return status;
    }

    @DeleteMapping("/deleteallproducts")
    public String deleteAllProducts()
    {
        String status = productService.deleteAll();
        return status;
    }

    @GetMapping("/productratingsummary")
    public Double getProductRatingSummary(@RequestParam Integer productId)
    {
        return productRatingService.findProductRatingSummary(productId);
    }

//    @GetMapping("/getproductslike")
//    public ResponseEntity<List<Product>> getProductsLike(@RequestParam String productName)
//    {
//        List<Product> productList=productService.findByProductNameLike(productName);
//        return new ResponseEntity<>(productList, HttpStatus.OK);
//    }
}
