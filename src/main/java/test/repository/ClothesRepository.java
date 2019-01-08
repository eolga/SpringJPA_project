package test.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import test.entity.Clothes;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ClothesRepository extends PagingAndSortingRepository<Clothes, Integer> {
    Optional<Clothes> findById(Long id);
    List<Clothes> findAll();

    @Query("SELECT COUNT(entity)>0 FROM Clothes entity WHERE entity.id = :#{#_entity.id}")
    boolean isExists(@Param("_entity") Clothes _entity);

    @Modifying
    @Transactional
    @Query("DELETE FROM Clothes entity WHERE entity.id = :#{#_id}")
    void delete(@Param("_id") Optional<Clothes> _id);

    void update(@Param("_entity") Clothes _entity);

    //boolean isExists(Clothes entity);
}
