package com.techtalks.ecommerce.product_management.repository.helper;

import com.techtalks.ecommerce.product_management.domain.ProductRatingSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;

@Component
public class ProductRatingSummaryHelper {

    @Autowired
    EntityManager entityManager;

        public Double findProductRatingSummary(Integer productId)
        {
        Query productSummaryQuery = entityManager.createNativeQuery("SELECT CAST(ROUND(AVG(RATING),1) AS DOUBLE) FROM PRODUCT_RATINGS WHERE PRODUCT_ID=?");
        productSummaryQuery.setParameter(1, productId);
        Double productRating =(Double) productSummaryQuery.getSingleResult();
        return productRating;
        }
}
