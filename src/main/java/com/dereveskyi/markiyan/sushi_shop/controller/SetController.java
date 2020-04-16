package com.dereveskyi.markiyan.sushi_shop.controller;

import com.dereveskyi.markiyan.sushi_shop.dao.SetRepository;
import com.dereveskyi.markiyan.sushi_shop.model.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sets")
public class SetController {

    @Autowired
    SetRepository setRepository;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(setRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{setId}")
    public ResponseEntity<?> findById(@PathVariable("setId") String setId) {
        Optional<Set> optionalSet = setRepository.findById(Long.parseLong(setId));
        Set foundSet = optionalSet.get();
        return new ResponseEntity<>(foundSet, HttpStatus.OK);
    }

    @DeleteMapping("/{setId}")
    public ResponseEntity<?> delete(@PathVariable("setId") String setId) {
        setRepository.deleteById(Long.parseLong(setId));
        return new ResponseEntity<>("Sushi with ID ---> " + setId + " <--- was deleted successfully!", HttpStatus.OK);
    }
}
