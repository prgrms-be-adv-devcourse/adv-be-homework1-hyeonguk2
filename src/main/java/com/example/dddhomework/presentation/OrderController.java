package com.example.dddhomework.presentation;

import com.example.dddhomework.application.OrderService;
import com.example.dddhomework.common.ResponseEntity;
import com.example.dddhomework.domain.PurchaseOrder;
import com.example.dddhomework.domain.PurchaseOrderStatus;
import com.example.dddhomework.presentation.dto.OrderRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.v1}/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "주문 상태", description = "상품과 구매자 정보를 바탕으로 주문을 생성한다.")
    @PostMapping
    public ResponseEntity<PurchaseOrder> create(@RequestBody OrderRequest request){
        return orderService.create(request.toCommand());
    }

    @Operation(summary = "주문 목록 조회", description = "생성된 주문을 페이지 단위로 조회한다.")
    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> findAll(Pageable pageable) {
        return orderService.findAll(pageable);
    }

    @Operation(summary = "주문 상태 변경", description = "생성된 주문의 상태를 변경한다.")
    @PatchMapping("{id}/paid")
    public ResponseEntity<PurchaseOrder> paid(@PathVariable(name = "id") String id) {
        return orderService.statusChange(id, PurchaseOrderStatus.PAID);
    }

    @Operation(summary = "주문 상태 취소", description = "생성된 주문의 상태를 취소한다.")
    @PatchMapping("{id}/cancelled")
    public ResponseEntity<PurchaseOrder> cancelled(@PathVariable(name = "id") String id) {
        return orderService.statusChange(id, PurchaseOrderStatus.CANCELLED);
    }

}
