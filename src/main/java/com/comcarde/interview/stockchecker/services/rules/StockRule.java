package com.comcarde.interview.stockchecker.services.rules;

import com.comcarde.interview.stockchecker.models.Product;
import com.comcarde.interview.stockchecker.models.ProductLog;
import org.springframework.stereotype.Service;

@Service
public class StockRule {
    private final static String STOCK_EXCEPTION_TEMPLATE = "Need to purchase %d for %s to reach min stock of %d";

    public Product hasMinStock(Product p) {
        if (p != null && p.getRule() != null) {
            long requiredStock =  p.getQuantity() - p.getRule().getMinQuantity();
            if(requiredStock < 0) {
                p.getProductLogList().add(buildProductLog(p, requiredStock));
            }
        }
        return p;
    }

    private ProductLog buildProductLog(Product p, long requiredStock) {
        ProductLog productLog = new ProductLog();
        productLog.setProductName(p.getName());
        productLog.setDescription(String.format(STOCK_EXCEPTION_TEMPLATE, Math.abs(requiredStock), p.getName(), p.getRule().getMinQuantity()));
        productLog.setQuantityToPurchase(Math.abs(requiredStock));
        return productLog;
    }
}
