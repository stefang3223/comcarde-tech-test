package com.comcarde.interview.stockchecker.services;

import com.comcarde.interview.stockchecker.models.Product;
import com.comcarde.interview.stockchecker.models.ProductLog;
import com.comcarde.interview.stockchecker.repositories.ProductRepository;
import com.comcarde.interview.stockchecker.services.rules.OrderRule;
import com.comcarde.interview.stockchecker.services.rules.StatusRule;
import com.comcarde.interview.stockchecker.services.rules.StockRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final StatusRule statusRule;
    private final StockRule stockRule;
    private final OrderRule orderRule;
    private final ProductLogService productLogService;

    public List<ProductLog> getProductStatusList() {
        List<Product> products = productRepository.findAll()
            .stream()
            .filter(statusRule::isActiveProduct)
            .map(stockRule::hasMinStock)
            .map(orderRule::hasAdhocOrderStock)
            .collect(Collectors.toList());

        productLogService.persistLogs(products);
        return toProductLogList(products);
    }

    private List<ProductLog> toProductLogList(List<Product> products) {
        return products.stream()
            .map(Product::getProductLogList)
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }
}
