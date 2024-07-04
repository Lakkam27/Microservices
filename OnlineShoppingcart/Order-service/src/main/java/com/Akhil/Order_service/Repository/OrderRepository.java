package com.Akhil.Order_service.Repository;

import com.Akhil.Order_service.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}