package com.techtalks.ecommerce.product_management.repository;

import com.techtalks.ecommerce.product_management.domain.ProductRating;
import com.techtalks.ecommerce.product_management.domain.ProductRatingSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface ProductRatingRepository extends JpaRepository<ProductRating,Integer> {


}
