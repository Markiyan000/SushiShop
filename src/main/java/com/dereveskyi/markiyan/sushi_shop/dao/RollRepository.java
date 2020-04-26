package com.dereveskyi.markiyan.sushi_shop.dao;

        import com.dereveskyi.markiyan.sushi_shop.model.Roll;
        import org.springframework.data.domain.Sort;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.PagingAndSortingRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;
        import java.util.Optional;

@Repository
public interface RollRepository extends PagingAndSortingRepository<Roll, Long> {
    Iterable<Roll> findAll(Sort sort);

    Optional<Roll> findById(Long id);

    @Query("select r from Roll r where r.name like %:searchName%")
    Iterable<Roll> findByName(@Param("searchName") String searchName);

    Iterable<Roll> findByType(String searchType);
}
