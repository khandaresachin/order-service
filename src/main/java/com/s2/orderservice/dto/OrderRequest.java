package com.s2.orderservice.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    @NotNull
    private String orderInfo;
    @NotNull
    private String city;
    @NotNull
    private Long pinCode;
    @NotNull
    private Integer quantity;
    @NotNull
    private String paymentMode;
    private String orderStatus;

}
