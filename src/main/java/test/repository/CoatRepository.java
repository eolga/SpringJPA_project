package test.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import test.entity.Coat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CoatRepository extends PagingAndSortingRepository<Coat, Integer>{
    Optional<Coat> findById(Long id);
    List<Coat> findAll();

    @Query("SELECT COUNT(entity)>0 FROM Goods entity WHERE entity.id = :#{#_entity.id}")
    boolean isIdExists(@Param("_entity") Coat _entity);

    @Modifying
    @Transactional
    @Query("DELETE FROM Goods entity WHERE entity.id = :#{#_id}")
    void delete(@Param("_id") Optional<Coat> _id);


    void update(@Param("_entity") Coat _entity);

}
