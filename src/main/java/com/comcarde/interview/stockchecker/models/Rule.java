package com.comcarde.interview.stockchecker.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "RULE_STATUS")
    private RuleStatus status;

    @Column(name = "MIN_QUANTITY")
    private int minQuantity;
}