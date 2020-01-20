package com.comcarde.interview.stockchecker.services.rules;

import com.comcarde.interview.stockchecker.models.Product;
import com.comcarde.interview.stockchecker.models.Rule;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class StockRuleTest {
    @Test
    public void given_productWithNotEnoughStock_when_hasMinStock_then_returnsRequiredStock() {
        // given
        Product p = new Product();
        p.setQuantity(2);
        Rule r = new Rule();
        r.setMinQuantity(5);
        p.setRule(r);

        // when
        assertTrue(p.getProductLogList().isEmpty());
        p = new StockRule().hasMinStock(p);

        // then
        assertFalse(p.getProductLogList().isEmpty());
        assertEquals(3, p.getProductLogList().get(0).getQuantityToPurchase());
    }

    @Test
    public void given_productWithEnoughStock_when_hasMinStock_then_returnsNoStockToPurchase(){
        // given
        Product p = new Product();
        p.setQuantity(5);
        Rule r = new Rule();
        r.setMinQuantity(5);
        p.setRule(r);

        // when
        assertTrue(p.getProductLogList().isEmpty());
        p = new StockRule().hasMinStock(p);

        // then
        assertTrue(p.getProductLogList().isEmpty());
        p = new StockRule().hasMinStock(p);
    }
}