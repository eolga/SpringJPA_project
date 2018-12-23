package test.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import test.entity.OrderPos;

import java.util.List;

public interface OrderPosRepository extends PagingAndSortingRepository<OrderPos, Integer> {
    @Query("SELECT entity FROM OrderPos entity")
    List<OrderPos> getAll();

    @Query("SELECT COUNT(entity)>0 FROM OrderPos entity WHERE entity.id = :#{#_entity.id}")
    boolean isExists(@Param("_entity") OrderPos _entity);
}
