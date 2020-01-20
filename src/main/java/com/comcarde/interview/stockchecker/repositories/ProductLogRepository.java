package com.comcarde.interview.stockchecker.repositories;

import com.comcarde.interview.stockchecker.models.ProductLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLogRepository extends JpaRepository<ProductLog, Long> {}
