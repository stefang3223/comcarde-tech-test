package com.comcarde.interview.stockchecker.services.rules;

import com.comcarde.interview.stockchecker.models.AdhocOrder;
import com.comcarde.interview.stockchecker.models.Product;
import com.comcarde.interview.stockchecker.models.ProductLog;
import org.springframework.stereotype.Service;

@Service
public class OrderRule {
    private final static String ADHOC_ORDER_EXCEPTION_TEMPLATE = "Need to purchase %d for %s to reach required stock for adhoc orders";;

    public Product hasAdhocOrderStock(Product p) {
        if(p != null && p.getRule() != null && p.getOrders() != null && !p.getOrders().isEmpty()) {
            long stockAfterOrders = p.getQuantity() - getRequiredOrderStock(p);
            if(stockAfterOrders < 0) {
                p.getProductLogList().add(buildProductLog(p, stockAfterOrders));
            }
        }
        return p;
    }

    protected long getRequiredOrderStock(Product p) {
        return p.getOrders()
                .stream()
                .mapToInt(AdhocOrder::getQuantity)
                .sum();
    }

    private ProductLog buildProductLog(Product p, long stockAfterOrders) {
        ProductLog productLog = new ProductLog();
        productLog.setProductName(p.getName());
        productLog.setDescription(String.format(ADHOC_ORDER_EXCEPTION_TEMPLATE, Math.abs(stockAfterOrders), p.getName()));
        productLog.setQuantityToPurchase(Math.abs(stockAfterOrders));
        return productLog;
    }
}
