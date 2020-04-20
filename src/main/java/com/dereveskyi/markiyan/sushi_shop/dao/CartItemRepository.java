package com.dereveskyi.markiyan.sushi_shop.dao;

import com.dereveskyi.markiyan.sushi_shop.model.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    Iterable<CartItem> findAll();
}
