package test.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import test.entity.User;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    @Query("SELECT entity FROM User entity")
    List<User> getAll();

    @Query("SELECT COUNT(entity)>0 FROM User entity WHERE entity.id = :#{#_entity.id}")
    boolean isExists(@Param("_entity") User _entity);
}
