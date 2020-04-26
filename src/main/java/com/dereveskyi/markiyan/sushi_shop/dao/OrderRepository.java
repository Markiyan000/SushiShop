package com.dereveskyi.markiyan.sushi_shop.dao;

import com.dereveskyi.markiyan.sushi_shop.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
