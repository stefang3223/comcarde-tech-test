package com.comcarde.interview.stockchecker.repositories;

import com.comcarde.interview.stockchecker.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
