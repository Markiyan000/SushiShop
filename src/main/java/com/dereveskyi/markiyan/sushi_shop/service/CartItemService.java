package com.dereveskyi.markiyan.sushi_shop.service;

import com.dereveskyi.markiyan.sushi_shop.dao.CartItemRepository;
import com.dereveskyi.markiyan.sushi_shop.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
