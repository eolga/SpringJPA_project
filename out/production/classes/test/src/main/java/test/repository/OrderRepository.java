package test.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import test.entity.Order;

import java.util.List;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
    @Query("SELECT entity FROM Order entity")
    List<Order> getAll();

    @Query("SELECT COUNT(entity)>0 FROM Order entity WHERE entity.id = :#{#_entity.id}")
    boolean isExists(@Param("_entity") Order _entity);
}
