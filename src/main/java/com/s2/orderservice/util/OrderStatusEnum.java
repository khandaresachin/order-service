package com.s2.orderservice.util;

public enum OrderStatusEnum {
    CREATED("CREATED"),
    IN_TRANSIT("IN TRANSIT"),
    OUT_FOR_DELIVERY("OUT FOR DELIVERY"),
    DELIVERED("DELIVERED");

    String value;

    OrderStatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
        return value;
    }
}
