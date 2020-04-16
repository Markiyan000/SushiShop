package com.dereveskyi.markiyan.sushi_shop.controller;

import com.dereveskyi.markiyan.sushi_shop.model.Roll;
import com.dereveskyi.markiyan.sushi_shop.service.RollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/rolls")
@CrossOrigin
public class RollController {

    @Autowired
    RollService rollService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(rollService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{rollId}")
    public ResponseEntity<?> findById(@PathVariable("rollId") String rollId) {
        Optional<Roll> optionalRoll = rollService.findById(Long.parseLong(rollId));
        Roll foundRoll = optionalRoll.get();
        return new ResponseEntity<>(foundRoll, HttpStatus.OK);
    }

    @DeleteMapping("{rollId}")
    public ResponseEntity<?> delete(@PathVariable("rollId") String rollId) {
        rollService.delete(Long.parseLong(rollId));
        return new ResponseEntity<>("Roll with ID ---> " + rollId + " <--- was deleted successfully!", HttpStatus.OK);
    }
}
