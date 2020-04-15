package com.dereveskyi.markiyan.sushi_shop.service;

import com.dereveskyi.markiyan.sushi_shop.dao.SushiRepository;
import com.dereveskyi.markiyan.sushi_shop.model.Sushi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SushiService {

    @Autowired
    SushiRepository sushiRepository;

    public Iterable<Sushi> findAll() {
        return sushiRepository.findAll();
    }

    public Optional<Sushi> findById(Long sushiId) {
        return sushiRepository.findById(sushiId);
    }

    public void delete(Long sushiId) {
        sushiRepository.deleteById(sushiId);
    }
}