package com.dereveskyi.markiyan.sushi_shop.service;

import com.dereveskyi.markiyan.sushi_shop.dao.SetRepository;
import com.dereveskyi.markiyan.sushi_shop.model.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SetService {

    @Autowired
    SetRepository setRepository;

    public Iterable<Set> findAll() {
        return setRepository.findAll();
    }

    public Optional<Set> findById(Long setId) {
        return setRepository.findById(setId);
    }

    public void delete(Long setId) {
        setRepository.deleteById(setId);
    }
}
