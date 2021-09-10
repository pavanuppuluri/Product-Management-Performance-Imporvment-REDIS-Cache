package com.techtalks.ecommerce.product_management.mappers;

import com.techtalks.ecommerce.product_management.domain.Product;
import com.techtalks.ecommerce.product_management.dtos.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoToProductMapper {

    @Autowired
    ModelMapper modelMapper;

    public Product mapProductDtoToProduct(ProductDto productDto)
    {
        return modelMapper.map(productDto, Product.class);
    }
}
