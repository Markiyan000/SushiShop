package com.dereveskyi.markiyan.sushi_shop.service;

import com.dereveskyi.markiyan.sushi_shop.dao.RollRepository;
import com.dereveskyi.markiyan.sushi_shop.model.Roll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RollService {
    @Autowired
    RollRepository rollRepository;

    public Iterable<Roll> findAll(String sortBy) {
        Sort sortOrder = Sort.by(sortBy);
        return rollRepository.findAll(sortOrder);
    }

    public Optional<Roll> findById(Long rollId) {
        return rollRepository.findById(rollId);
    }

    public void delete(Long rollId) {
        rollRepository.deleteById(rollId);
    }

    public Iterable<Roll> findByName(String searchName) {
        return rollRepository.findByName(searchName);
    }

    public Iterable<Roll> findByType(String searchType) {
        return rollRepository.findByType(searchType);
    }
}
