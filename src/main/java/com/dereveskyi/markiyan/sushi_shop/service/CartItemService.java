package com.dereveskyi.markiyan.sushi_shop.service;

import com.dereveskyi.markiyan.sushi_shop.dao.CartItemRepository;
import com.dereveskyi.markiyan.sushi_shop.model.CartItem;
import com.dereveskyi.markiyan.sushi_shop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;

    public Iterable<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    public void delete(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void save(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    public Integer getTotalSum() {
        return cartItemRepository.getTotalSum();
    }

    @Transactional
    public void updateOrderId(Order order) {
        cartItemRepository.updateOrderId(order);
    }

    @Transactional
    public void clearCart() {
        cartItemRepository.clearCart();
    }
}