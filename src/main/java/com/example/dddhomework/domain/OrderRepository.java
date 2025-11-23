package com.example.dddhomework.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderRepository {

    PurchaseOrder save(PurchaseOrder order);
    Page<PurchaseOrder> findAll(Pageable pageable);
}
