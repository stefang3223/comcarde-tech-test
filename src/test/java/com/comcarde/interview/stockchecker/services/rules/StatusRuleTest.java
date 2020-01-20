package com.comcarde.interview.stockchecker.services.rules;

import com.comcarde.interview.stockchecker.models.Product;
import com.comcarde.interview.stockchecker.models.Rule;
import com.comcarde.interview.stockchecker.models.RuleStatus;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class StatusRuleTest {
    @Test
    public void given_activeProduct_when_isActiveProduct_then_returnsTrue() {
        // given
        Product p = new Product();
        Rule r = new Rule();
        r.setStatus(RuleStatus.ACTIVE);
        p.setRule(r);

        // when
        boolean result = new StatusRule().isActiveProduct(p);

        // then
        assertTrue(result);
    }

    @Test
    public void given_blockedProduct_when_isActiveProduct_then_returnsFalse() {
        // given
        Product p = new Product();
        Rule r = new Rule();
        r.setStatus(RuleStatus.BLOCKED);
        p.setRule(r);

        // when
        boolean result = new StatusRule().isActiveProduct(p);

        // then
        assertFalse(result);
    }
}