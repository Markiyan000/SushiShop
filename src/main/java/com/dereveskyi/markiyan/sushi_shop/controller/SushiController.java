package com.dereveskyi.markiyan.sushi_shop.controller;

import com.dereveskyi.markiyan.sushi_shop.model.Sushi;
import com.dereveskyi.markiyan.sushi_shop.service.SushiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sushi")
@CrossOrigin
public class SushiController {

    @Autowired
    SushiService sushiService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(sushiService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{sushiId}")
    public ResponseEntity<?> findById(@PathVariable("sushiId") String sushiId) {
        Optional<Sushi> optionalSushi = sushiService.findById(Long.parseLong(sushiId));
        Sushi foundSushi = optionalSushi.get();
        return new ResponseEntity<>(foundSushi, HttpStatus.OK);
    }

    @DeleteMapping("/{sushiId}")
    public ResponseEntity<?> delete(@PathVariable("sushiId") String sushiId) {
        sushiService.delete(Long.parseLong(sushiId));
        return new ResponseEntity<>("Sushi with ID ---> " + sushiId + " <--- was deleted successfully!", HttpStatus.OK);
    }
}
