package com.comcarde.interview.stockchecker.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AdhocOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    private boolean isActive;
    private int quantity;
}
