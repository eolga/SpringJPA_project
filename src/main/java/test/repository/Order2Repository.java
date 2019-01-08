package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity2.Order2;

import java.util.List;
import java.util.Optional;

public interface Order2Repository extends PagingAndSortingRepository<Order2, Integer> {
    Optional<Order2> findById(Integer id);
    List<Order2> findAll();

}
