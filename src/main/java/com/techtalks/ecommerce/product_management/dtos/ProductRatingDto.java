package com.techtalks.ecommerce.product_management.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRatingDto {
    Integer productId;
    Integer userId;
    Integer rating;
}
