package com.epicode.U5D4.repositories;

import com.epicode.U5D4.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDAO extends JpaRepository<Order, Long> {
}
