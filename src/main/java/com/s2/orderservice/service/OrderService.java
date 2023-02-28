package com.s2.orderservice.service;

import com.s2.orderservice.dto.OrderRequest;
import com.s2.orderservice.dto.UpdateOrderRequest;
import com.s2.orderservice.entity.OrderInformation;
import com.s2.orderservice.exception.OrderNotFoundException;
import com.s2.orderservice.repository.OrderInformationRepository;
import com.s2.orderservice.util.OrderStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    Logger logger = LoggerFactory.getLogger(OrderService.class);
    private OrderInformationRepository repository;

    @Autowired
    public OrderService(OrderInformationRepository repository) {
        this.repository = repository;
    }

    public OrderInformation createOrder(OrderRequest request) {

        OrderInformation orderInfo = new OrderInformation();
        orderInfo.setOrderInfo(request.getOrderInfo());
        orderInfo.setOrderDateTime(LocalDateTime.now());
        orderInfo.setCity(request.getCity());
        orderInfo.setPinCode(request.getPinCode());
        orderInfo.setQuantity(request.getQuantity());
        orderInfo.setPaymentMode(request.getPaymentMode());
        orderInfo.setOrderStatus(OrderStatusEnum.CREATED.getValue());

        return repository.save(orderInfo);
    }

    /**
     * This method will return the order information for provided order id
     * if not found it will return null
     *
     * @param id
     * @return
     */
    public OrderInformation getSingleOrder(Integer id) {
        logger.info("Executing getSingleOrder into OrderService for orderId: {} ", id);
        return repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order Id is not found"));
    }

    public ResponseEntity<String> deleteOrderById(Integer id) {
        repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order Id not to delete"));

        repository.deleteById(id); // hard deletion
        return new ResponseEntity<>("Order has been removed successfully", HttpStatus.OK);
    }

    public ResponseEntity<OrderInformation> updateOrder(Integer id, UpdateOrderRequest request) {
        logger.info("Update request :{} for id :{} ", request, id);
        OrderInformation orderInformation = repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found to update"));
        orderInformation.setOrderStatus(request.getOrderStatus());
        repository.save(orderInformation);
        return new ResponseEntity<>(orderInformation, HttpStatus.ACCEPTED);
    }
}
