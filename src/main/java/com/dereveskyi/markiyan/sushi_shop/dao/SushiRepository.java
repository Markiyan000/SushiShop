package com.dereveskyi.markiyan.sushi_shop.dao;

import com.dereveskyi.markiyan.sushi_shop.model.Sushi;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SushiRepository extends PagingAndSortingRepository<Sushi, Long> {
    Iterable<Sushi> findAll(Sort sort);

    Optional<Sushi> findById(Long id);

}
