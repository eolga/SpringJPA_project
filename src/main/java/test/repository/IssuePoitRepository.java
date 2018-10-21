package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.IssuePoit;

public interface IssuePoitRepository extends PagingAndSortingRepository<IssuePoit, Integer> {
}
