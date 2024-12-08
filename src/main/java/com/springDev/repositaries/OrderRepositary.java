package com.springDev.repositaries;

import com.springDev.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositary extends JpaRepository<Order,Long> {
}
