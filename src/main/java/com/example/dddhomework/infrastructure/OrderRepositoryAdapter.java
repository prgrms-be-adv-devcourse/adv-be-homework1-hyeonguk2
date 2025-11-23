package com.example.dddhomework.infrastructure;

import com.example.dddhomework.domain.OrderRepository;
import com.example.dddhomework.domain.PurchaseOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository repository;

    public OrderRepositoryAdapter(OrderJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseOrder save(PurchaseOrder order) {
        return repository.save(order);
    }

    @Override
    public Page<PurchaseOrder> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }




























}
