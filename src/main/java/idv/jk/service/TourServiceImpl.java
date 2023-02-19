package idv.jk.service;

import idv.jk.ToursRepository;
import idv.jk.exception.ResourceAlreadyExistsException;
import idv.jk.exception.ResourceNotFoundException;
import idv.jk.model.Tour;
import idv.jk.model.TourRequest;
import idv.jk.transformer.Transformer;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {
    private final ToursRepository toursRepository;
//    private final Validator validator;    //  Another way to validate

    public TourServiceImpl(ToursRepository toursRepository) {
        this.toursRepository = toursRepository;
//        this.validator = validator;
    }

    @Override
    public Tour getById(String id) {
        final var result = toursRepository.findById(id);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Tour not found for id '%s'", id));
        }
        return result.get();
    }

    @Override
    public List<Tour> getAll() {
        return toursRepository.findAll();
    }

    @Override
    public Tour createTour(Tour tour) {
// One way to validate the parameter
//        Set<ConstraintViolation<Tour>> violations = validator.validate(tour);
//        if (!violations.isEmpty()) {
//            StringBuilder sb = new StringBuilder();
//            for (ConstraintViolation<Tour> constraintViolation : violations) {
//                sb.append(constraintViolation.getMessage());
//            }
//
//            throw new ConstraintViolationException("Error occurred: " + sb, violations);
//        }
        final var original = toursRepository.findByName(tour.getName());
        if (original.isPresent()) {
            throw new ResourceAlreadyExistsException(String.format("Tour with name '%s' already exists.", tour.getName()));
        }
        return toursRepository.save(tour);
    }

    @Override
    public Tour updateTour(String id, Tour tour) {
        final var original = getById(id);
        tour.setId(original.getId());
        Tour result = toursRepository.save(tour);
        return result;
    }

    @Override
    public void deleteTour(String id) {
        final var original = getById(id);
        toursRepository.delete(original);
    }
}
