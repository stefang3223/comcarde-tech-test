package com.comcarde.interview.stockchecker.services;

import com.comcarde.interview.stockchecker.models.Product;
import com.comcarde.interview.stockchecker.models.ProductLog;
import com.comcarde.interview.stockchecker.repositories.ProductLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductLogService {
    private final ProductLogRepository productLogRepository;

    public void persistLogs(List<Product> products) {
        List<ProductLog> logs = products.stream()
            .map(Product::getProductLogList)
            .flatMap(List::stream)
            .collect(Collectors.toList());
        productLogRepository.saveAll(logs);
    }
}
