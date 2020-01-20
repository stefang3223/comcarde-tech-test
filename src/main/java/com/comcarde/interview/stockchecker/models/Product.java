package com.comcarde.interview.stockchecker.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long quantity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID")
    private Rule rule;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    private List<AdhocOrder> orders;

    @Transient
    private List<ProductLog> productLogList = new ArrayList<>();
}
