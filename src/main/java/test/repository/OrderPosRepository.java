package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.Order;
import test.entity.OrderPos;

public interface OrderPosRepository extends PagingAndSortingRepository<OrderPos, Integer> {
}
