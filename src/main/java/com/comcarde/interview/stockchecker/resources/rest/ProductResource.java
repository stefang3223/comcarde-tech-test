package com.comcarde.interview.stockchecker.resources.rest;

import com.comcarde.interview.stockchecker.models.ProductLog;
import com.comcarde.interview.stockchecker.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductResource {
    private final ProductService productService;

    @GetMapping("/status")
    public List<ProductLog> get() {
        return productService.getProductStatusList();
    }
}
