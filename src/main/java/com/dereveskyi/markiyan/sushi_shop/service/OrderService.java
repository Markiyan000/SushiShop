package com.dereveskyi.markiyan.sushi_shop.service;

import com.dereveskyi.markiyan.sushi_shop.dao.OrderRepository;
import com.dereveskyi.markiyan.sushi_shop.model.CartItem;
import com.dereveskyi.markiyan.sushi_shop.model.Order;
import com.dereveskyi.markiyan.sushi_shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    CartItemService cartItemService;

    @Autowired
    OrderRepository orderRepository;

    public void makeOrder(User user) {
        Order order = new Order();
        order.setUser(user);
        saveOrder(order);
        cartItemService.updateOrderId(order);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
