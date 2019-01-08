package test.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import test.entity.IssuePoint;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IssuePointRepository extends PagingAndSortingRepository<IssuePoint, Integer> {
    Optional<IssuePoint> findById(Integer id);

    List<IssuePoint> findAll();


    @Query("SELECT COUNT(entity) FROM Point entity")
    Integer Count(@Param("_entity") IssuePoint _entity);

    @Modifying
    @Transactional
    @Query("DELETE FROM Point entity WHERE entity.id = :#{#_id}")
    void delete(@Param("_id") Optional<IssuePoint> _id);


    boolean isIdExists(@Param("_entity") IssuePoint _entity);

    void update(@Param("_entity") IssuePoint _entity);


    @Query("SELECT entity FROM IssuePoint2 entity")
    List<IssuePoint> getAll();

    boolean isExists(@Param("_entity") IssuePoint _entity);
}

   /*@Query("SELECT COUNT(entity)>0 FROM IssuePoint2 entity WHERE entity.id = :#{#_entity.id}")
    boolean isExists(@Param("_entity") IssuePoint _entity);
}*/
