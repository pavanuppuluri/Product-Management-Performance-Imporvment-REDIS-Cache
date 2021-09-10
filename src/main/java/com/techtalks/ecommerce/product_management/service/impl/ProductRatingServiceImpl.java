package com.techtalks.ecommerce.product_management.service.impl;

import com.techtalks.ecommerce.product_management.domain.Product;
import com.techtalks.ecommerce.product_management.domain.ProductRating;
import com.techtalks.ecommerce.product_management.domain.ProductRatingSummary;
import com.techtalks.ecommerce.product_management.dtos.ProductRatingDto;
import com.techtalks.ecommerce.product_management.mappers.ProductRatingDtoToProductRatingMapper;
import com.techtalks.ecommerce.product_management.repository.ProductRatingRepository;
import com.techtalks.ecommerce.product_management.repository.helper.ProductRatingSummaryHelper;
import com.techtalks.ecommerce.product_management.service.ProductRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRatingServiceImpl implements ProductRatingService {

    @Autowired
    ProductRatingSummaryHelper productRatingSummaryHelper;


    @Cacheable(value = "productRatingsCache", unless="#result == null")
    @Override
    public Double findProductRatingSummary(Integer productId) {
        System.out.println("Inside findProductRatingSummary");
        return productRatingSummaryHelper.findProductRatingSummary(productId);
    }
}
