package com.techtalks.ecommerce.product_management.service;

import com.techtalks.ecommerce.product_management.domain.ProductRatingSummary;

import java.util.List;

public interface ProductRatingService {
    Double findProductRatingSummary(Integer productId);
}
