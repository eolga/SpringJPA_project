package test.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import test.entity.Clothes;

import java.util.List;

public interface ClothesRepository extends PagingAndSortingRepository<Clothes, Integer> {
    @Query("SELECT entity FROM Clothes entity")
    List<Clothes> getAll();

    @Query("SELECT COUNT(entity)>0 FROM Clothes entity WHERE entity.id = :#{#_entity.id}")
    boolean isExists(@Param("_entity") Clothes _entity);
}
