package com.comcarde.interview.stockchecker.services.rules;

import com.comcarde.interview.stockchecker.models.Product;
import com.comcarde.interview.stockchecker.models.RuleStatus;
import org.springframework.stereotype.Service;

@Service
public class StatusRule {
    public boolean isActiveProduct(Product p) {
        return p.getRule() != null &&
                p.getRule().getStatus() != null &&
                p.getRule().getStatus().equals(RuleStatus.ACTIVE);
    }
}
