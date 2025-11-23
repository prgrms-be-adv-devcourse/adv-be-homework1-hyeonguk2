package com.example.dddhomework.application.dto;

import com.example.dddhomework.domain.PurchaseOrder;
import com.example.dddhomework.domain.PurchaseOrderStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderCommand (
        UUID productId,
        UUID sellerId,
        UUID memberId,
        BigDecimal amount,
        PurchaseOrderStatus status
){
}
