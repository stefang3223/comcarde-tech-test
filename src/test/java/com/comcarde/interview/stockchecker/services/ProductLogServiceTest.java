package com.comcarde.interview.stockchecker.services;

import com.comcarde.interview.stockchecker.models.Product;
import com.comcarde.interview.stockchecker.models.ProductLog;
import com.comcarde.interview.stockchecker.repositories.ProductLogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class ProductLogServiceTest {
    @Autowired private ProductLogService productLogService;
    @Autowired private ProductLogRepository productLogRepository;

    @Test
    public void given_productsWithLogs_when_persistLogs_then_logsEntriesInDatabase() {
        // given
        Product p = new Product();
        p.setProductLogList(Collections.singletonList(new ProductLog()));
        int sizeBefore = productLogRepository.findAll().size();

        // when
        productLogService.persistLogs(Collections.singletonList(p));

        // then
        int expected = sizeBefore + 1;
        int sizeAfter = productLogRepository.findAll().size();
        assertEquals(expected, sizeAfter);
    }

    @Test
    public void given_productsWithNoLogs_when_persistLogs_then_doesNotLogInDatabase() {
        // given
        Product p = new Product();
        int sizeBefore = productLogRepository.findAll().size();

        // when
        productLogService.persistLogs(Collections.singletonList(p));

        // then
        int sizeAfter = productLogRepository.findAll().size();
        assertEquals(sizeBefore, sizeAfter);
    }
}