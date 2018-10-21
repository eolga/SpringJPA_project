package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.Clothes;

public interface ClothesRepository extends PagingAndSortingRepository<Clothes, Integer> {
}
