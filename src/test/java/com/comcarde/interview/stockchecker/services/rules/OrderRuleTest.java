package com.comcarde.interview.stockchecker.services.rules;

import com.comcarde.interview.stockchecker.models.AdhocOrder;
import com.comcarde.interview.stockchecker.models.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderRuleTest {
    @Test
    public void given_productWithOrdersAndNoQuantity_when_getRequiredOrderStock_then_returnsStockForOrder() {
        // given
        Product p = new Product();
        AdhocOrder o = new AdhocOrder();
        o.setQuantity(5);
        p.setOrders(Collections.singletonList(o));

        // when
        long result = new OrderRule().getRequiredOrderStock(p);

        // then
        assertEquals(5, result);
    }

    @Test
    public void given_productWithNoOrders_when_getRequiredOrdersStock_then_returnZero() {
        // given
        Product p = new Product();
        p.setOrders(new ArrayList<>());

        // when
        long result = new OrderRule().getRequiredOrderStock(p);

        // then
        assertEquals(0, result);
    }
}
