package com.dereveskyi.markiyan.sushi_shop.dao;

import com.dereveskyi.markiyan.sushi_shop.model.Roll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RollRepository extends CrudRepository<Roll, Long> {
    Iterable<Roll> findAll();

    Optional<Roll> findById(Long rollId);
}
