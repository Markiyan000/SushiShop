package com.dereveskyi.markiyan.sushi_shop.dao;

import com.dereveskyi.markiyan.sushi_shop.model.CartItem;
import com.dereveskyi.markiyan.sushi_shop.model.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    @Query("select ci from CartItem ci where ci.order = null")
    Iterable<CartItem> findAll();

    @Modifying
    @Query("update CartItem c set c.order = :order where c.order = null")
    void updateOrderId(@Param("order") Order order);

    @Query("select sum(price) from CartItem c")
    Integer getTotalSum();

    @Modifying
    @Query("delete  from CartItem c where c.order is null")
    void clearCart();
}