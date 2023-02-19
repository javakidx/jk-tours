package idv.jk;

import idv.jk.model.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToursRepository extends MongoRepository<Tour, String> {
    @Query("{}")
    List<Tour> findAll();

    @Query("{name:'?0'}")
    Optional<Tour> findByName(String name);
}
