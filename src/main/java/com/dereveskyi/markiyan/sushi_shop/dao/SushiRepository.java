package com.dereveskyi.markiyan.sushi_shop.dao;

import com.dereveskyi.markiyan.sushi_shop.model.Sushi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SushiRepository extends CrudRepository<Sushi, Long> {
    Iterable<Sushi> findAll();
    Optional<Sushi> findById(Long sushiId);
}
