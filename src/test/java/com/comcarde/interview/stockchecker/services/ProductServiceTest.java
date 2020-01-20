package com.comcarde.interview.stockchecker.services;

import com.comcarde.interview.stockchecker.models.ProductLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class ProductServiceTest {
    @Autowired private ProductService productService;

    @Test
    public void test_exampleFromTestBrief() {
        List<ProductLog> result = productService.getProductStatusList();

        long productDQuantity = result.stream()
                .filter(d-> d.getProductName().equals("d"))
                .mapToLong(ProductLog::getQuantityToPurchase)
                .sum();

        long productEQuantity = result.stream()
                .filter(d-> d.getProductName().equals("e"))
                .mapToLong(ProductLog::getQuantityToPurchase)
                .sum();

        assertEquals(23, productDQuantity);
        assertEquals(3, productEQuantity);
    }
}
