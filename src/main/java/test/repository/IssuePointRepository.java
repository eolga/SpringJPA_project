package test.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import test.entity.IssuePoint;

import java.util.List;

public interface IssuePointRepository extends PagingAndSortingRepository<IssuePoint, Integer> {
    @Query("SELECT entity FROM IssuePoint entity")
    List<IssuePoint> getAll();

    @Query("SELECT COUNT(entity)>0 FROM IssuePoint entity WHERE entity.id = :#{#_entity.id}")
    boolean isExists(@Param("_entity") IssuePoint _entity);
}
