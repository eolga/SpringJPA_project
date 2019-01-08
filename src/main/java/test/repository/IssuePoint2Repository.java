package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity2.IssuePoint2;

import java.util.List;
import java.util.Optional;

public interface IssuePoint2Repository extends PagingAndSortingRepository<IssuePoint2, Integer> {
        Optional<IssuePoint2> findById(Integer id);
        List<IssuePoint2> findAll();
}
