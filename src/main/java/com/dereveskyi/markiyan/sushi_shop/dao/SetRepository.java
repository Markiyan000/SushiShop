package com.dereveskyi.markiyan.sushi_shop.dao;

import com.dereveskyi.markiyan.sushi_shop.model.Set;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SetRepository extends CrudRepository<Set, Long> {
    Iterable<Set> findAll();

    Optional<Set> findById(Long setId);
}
