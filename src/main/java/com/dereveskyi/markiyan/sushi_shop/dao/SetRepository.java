package com.dereveskyi.markiyan.sushi_shop.dao;

import com.dereveskyi.markiyan.sushi_shop.model.Set;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SetRepository extends PagingAndSortingRepository<Set, Long> {
    Iterable<Set> findAll(Sort sort);

    Optional<Set> findById(Long id);

    @Query("select s from Set s where s.name like %:searchName%")
    Iterable<Set> findByName(String searchName);
}
