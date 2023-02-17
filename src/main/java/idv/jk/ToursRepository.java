package idv.jk;

import idv.jk.model.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToursRepository extends MongoRepository<Tour, String> {
    @Query("{}")
    List<Tour> findAll();
}
