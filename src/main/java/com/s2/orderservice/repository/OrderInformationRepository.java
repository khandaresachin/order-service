package com.s2.orderservice.repository;

import com.s2.orderservice.entity.OrderInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInformationRepository extends JpaRepository<OrderInformation, Integer> {

}
