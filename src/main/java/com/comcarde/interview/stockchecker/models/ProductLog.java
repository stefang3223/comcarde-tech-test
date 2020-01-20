package com.comcarde.interview.stockchecker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ProductLog {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String description;
    private long quantityToPurchase;
    private Date timestamp;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        timestamp = new Date();
    }

}
