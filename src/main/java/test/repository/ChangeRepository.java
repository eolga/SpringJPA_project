package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.ChangeAll;

import java.util.List;
import java.util.Optional;

public interface ChangeRepository extends PagingAndSortingRepository <ChangeAll, Integer>{
    Optional<ChangeAll> findById(Integer id);
    List<ChangeAll> findAll();
}
