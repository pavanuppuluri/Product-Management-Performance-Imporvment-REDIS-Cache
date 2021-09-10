package com.techtalks.ecommerce.product_management.domain;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCTS")
@Entity
@Builder
@Getter
@Setter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
    @SequenceGenerator(name="product_id_generator", sequenceName = "product_id_generator_seq")
    Integer productId;
    String productName;
    String productCategory;
    Double price;
    String currency;
    String description;
}
