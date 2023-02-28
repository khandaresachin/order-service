package com.s2.orderservice.controller;

import com.s2.orderservice.dto.OrderRequest;
import com.s2.orderservice.dto.UpdateOrderRequest;
import com.s2.orderservice.entity.OrderInformation;
import com.s2.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{id}")
    public OrderInformation getSingleOrder(
            @PathVariable Integer id
    ) {
        logger.info("Request for getSingleOrder for orderId :{}", id);
        return orderService.getSingleOrder(id);
    }

    @PostMapping("/order")
    public OrderInformation createDynamicMessage(
            @RequestBody OrderRequest request
    ) {
        return orderService.createOrder(request);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<String> deleteOrderById(
            @PathVariable Integer id
    ) {
        return orderService.deleteOrderById(id);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<OrderInformation> updateOrder(
            @PathVariable Integer id,
            @RequestBody UpdateOrderRequest request
            ){
        return orderService.updateOrder(id, request);
    }

}
