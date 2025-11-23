package com.example.payment.payment.infrastructure;

import com.example.payment.payment.domain.PaymentFailure;
import com.example.payment.payment.domain.PaymentFailureRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentFailureRepositoryAdapter implements PaymentFailureRepository {
    private final PaymentFailureJpaRepository repository;

    public PaymentFailureRepositoryAdapter(PaymentFailureJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentFailure save(PaymentFailure failure) {
        return repository.save(failure);
    }
}
