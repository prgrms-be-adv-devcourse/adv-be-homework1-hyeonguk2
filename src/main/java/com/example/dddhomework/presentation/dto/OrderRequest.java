package com.example.dddhomework.presentation.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.example.dddhomework.application.dto.OrderCommand;
import com.example.dddhomework.domain.PurchaseOrderStatus;
public record OrderRequest(

        String productId,
        String sellerId,
        String memberId,
        BigDecimal amount
) {
    public OrderCommand toCommand(){
//        UUID product = productId != null ? UUID.fromString(productId) : null;
//        UUID seller = sellerId != null ? UUID.fromString(sellerId) : null;
//        UUID member = memberId != null ? UUID.fromString(memberId) : null;

//        return new OrderCommand(product,seller,member,amount,PurchaseOrderStatus.CREATED);
        return new OrderCommand(UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),amount,PurchaseOrderStatus.CREATED);
    }

}
