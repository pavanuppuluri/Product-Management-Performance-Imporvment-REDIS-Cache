package com.techtalks.ecommerce.product_management.mappers;

import com.techtalks.ecommerce.product_management.domain.ProductRating;
import com.techtalks.ecommerce.product_management.dtos.ProductRatingDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductRatingDtoToProductRatingMapper {
    @Autowired
    ModelMapper modelMapper;

    public ProductRating mapProductRatingDtoToProductRating(ProductRatingDto productRatingDto)
    {
    return modelMapper.map(productRatingDto, ProductRating.class);
    }
}
