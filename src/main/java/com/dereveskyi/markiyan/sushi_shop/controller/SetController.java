package com.dereveskyi.markiyan.sushi_shop.controller;

import com.dereveskyi.markiyan.sushi_shop.model.Set;
import com.dereveskyi.markiyan.sushi_shop.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sets")
@CrossOrigin
public class SetController {

    @Autowired
    SetService setService;

    @GetMapping("")
    public ResponseEntity<?> findAll(@RequestParam(required = false, defaultValue = "id") String sortBy,
                                     @RequestParam(required = false) String searchName) {
        if(searchName == null) {
            return new ResponseEntity<>(setService.findAll(sortBy), HttpStatus.OK);
        }
        else return new ResponseEntity<>(setService.findByName(searchName), HttpStatus.OK);
    }

    @GetMapping("/{setId}")
    public ResponseEntity<?> findById(@PathVariable("setId") String setId) {
        Optional<Set> optionalSet = setService.findById(Long.parseLong(setId));
        Set foundSet = optionalSet.get();
        return new ResponseEntity<>(foundSet, HttpStatus.OK);
    }

    @DeleteMapping("/{setId}")
    public ResponseEntity<?> delete(@PathVariable("setId") String setId) {
        setService.delete(Long.parseLong(setId));
        return new ResponseEntity<>("Sushi with ID ---> " + setId + " <--- was deleted successfully!", HttpStatus.OK);
    }
}
