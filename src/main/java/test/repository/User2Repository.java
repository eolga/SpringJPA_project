package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity2.User2;

import java.util.List;
import java.util.Optional;

public interface User2Repository extends PagingAndSortingRepository<User2, Integer> {
    Optional<User2> findById(Integer id);
    List<User2> findAll();

}
