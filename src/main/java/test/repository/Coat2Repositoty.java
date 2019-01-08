package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity2.Coat2;

import java.util.List;
import java.util.Optional;

public interface Coat2Repositoty  extends PagingAndSortingRepository<Coat2, Integer> {
    Optional<Coat2> findById(Long id);
    List<Coat2> findAll();
}
