package com.techtalks.ecommerce.product_management.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    Integer productId;
    String productName;
    String productCategory;
    Double price;
    String currency;
    String description;
}
