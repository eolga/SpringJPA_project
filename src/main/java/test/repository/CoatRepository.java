package test.repository;

import test.entity.Coat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface CoatRepository extends PagingAndSortingRepository<Coat, Integer>{
    @Query("SELECT T FROM Coat T WHERE T.name LIKE CONCAT ('%', :text, '%')")
    List<Coat> findByNameLikeAnything (@Param("text") String text);

}
