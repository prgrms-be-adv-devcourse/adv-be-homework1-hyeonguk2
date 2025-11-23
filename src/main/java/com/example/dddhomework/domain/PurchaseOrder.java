package com.example.dddhomework.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(name = "\"purchase_order\"", schema = "public")
public class PurchaseOrder {

    @Id
    private UUID id;

    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Column(name = "seller_id", nullable = false)
    private UUID sellerId;

    @Column(name = "member_id", nullable = false)
    private UUID memberId;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PurchaseOrderStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public void markPaid() {
        this.status = PurchaseOrderStatus.PAID;
    }

    public PurchaseOrder(UUID id,
                         UUID productId,
                         UUID sellerId,
                         UUID memberId,
                         BigDecimal amount,
                         PurchaseOrderStatus status,
                         LocalDateTime createdAt,
                         LocalDateTime updatedAt) {

        this.id = id;
        this.productId = productId;
        this.sellerId = sellerId;
        this.memberId = memberId;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public static PurchaseOrder create(UUID productId,
                                 UUID sellerId,
                                 UUID memberId,
                                 BigDecimal amount,
                                 PurchaseOrderStatus status,
                                 LocalDateTime createdAt,
                                 LocalDateTime updatedAt
    ) {
        PurchaseOrder purchaseOrder = new PurchaseOrder(UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(), amount, status, createdAt, updatedAt);
        return purchaseOrder;
    }
    @PrePersist
    public void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        if (id == null) {
            id = UUID.randomUUID();
        }
        createdAt = now;
        updatedAt = now;
        if (status == null) {
            status = PurchaseOrderStatus.CREATED;
        }
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}