package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity2.OrderPos2;

import java.util.List;
import java.util.Optional;

public interface OrderPos2Repository extends PagingAndSortingRepository<OrderPos2, Integer> {
    Optional<OrderPos2> findById(Integer id);
    List<OrderPos2> findAll();

}
