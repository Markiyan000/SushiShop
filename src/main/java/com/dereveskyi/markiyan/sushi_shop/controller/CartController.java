
package com.dereveskyi.markiyan.sushi_shop.controller;

import com.dereveskyi.markiyan.sushi_shop.model.CartItem;
import com.dereveskyi.markiyan.sushi_shop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {
    @Autowired
    CartItemService cartItemService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(cartItemService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCartItem(@RequestBody CartItem cartItem) {
        cartItemService.save(cartItem);
        return new ResponseEntity<>(cartItem, HttpStatus.CREATED);
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<?> deleteById(@PathVariable("cartItemId") String cartItemId) {
        cartItemService.delete(Long.parseLong(cartItemId));
        return new ResponseEntity<>("Item with ID --->" + cartItemId + " <--- was deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> clearCart() {
        cartItemService.clearCart();
        return new ResponseEntity<>("Cart is removed successfully!", HttpStatus.OK);
    }
}