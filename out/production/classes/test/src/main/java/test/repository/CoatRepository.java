package test.repository;

import org.springframework.data.repository.query.Param;
import test.entity.Coat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CoatRepository extends PagingAndSortingRepository<Coat, Integer>{
    @Query("SELECT entity FROM Coat entity")
    List<Coat> getAll();

    @Query("SELECT COUNT(entity)>0 FROM Coat entity WHERE entity.id = :#{#_entity.id}")
    boolean isExists(@Param("_entity") Coat _entity);

}
