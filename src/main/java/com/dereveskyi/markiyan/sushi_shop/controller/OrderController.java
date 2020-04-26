package com.dereveskyi.markiyan.sushi_shop.controller;

import com.dereveskyi.markiyan.sushi_shop.model.User;
import com.dereveskyi.markiyan.sushi_shop.service.ErrorValidationService;
import com.dereveskyi.markiyan.sushi_shop.service.MailSenderService;
import com.dereveskyi.markiyan.sushi_shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ErrorValidationService errorValidationService;

    @Autowired
    MailSenderService mailSenderService;

    @PostMapping
    public ResponseEntity<?> makeOrder(@Valid @RequestBody User user, BindingResult bindingResult) {
        ResponseEntity<?> errorMap = errorValidationService.errorValidate(bindingResult);
        if (errorMap != null) return errorMap;
        orderService.makeOrder(user);
        mailSenderService.send(user);
        return new ResponseEntity<>("Order is executed!", HttpStatus.CREATED);
    }
}
