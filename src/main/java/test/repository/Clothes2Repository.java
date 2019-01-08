package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity2.Clothes2;

import java.util.List;
import java.util.Optional;

public interface Clothes2Repository extends PagingAndSortingRepository<Clothes2, Integer> {
    Optional<Clothes2> findById(Long id);
    List<Clothes2> findAll();
}
