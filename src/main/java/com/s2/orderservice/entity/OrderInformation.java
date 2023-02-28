package com.s2.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "order_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String orderInfo;
    private LocalDateTime orderDateTime;
    private String city;
    private Long pinCode;
    private Integer quantity;
    //private List<String> productIds;
    private String paymentMode;
    private String orderStatus;
}