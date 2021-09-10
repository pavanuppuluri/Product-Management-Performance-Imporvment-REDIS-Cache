package com.techtalks.ecommerce.product_management.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCT_RATINGS")
@Entity
@Builder
public class ProductRating {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_rating_id_generator")
    @SequenceGenerator(name="product_rating_id_generator", sequenceName = "product_rating_id_generator_seq")
    Integer productRatingId;
    Integer productId;
    Integer userId;
    Integer rating;
}
