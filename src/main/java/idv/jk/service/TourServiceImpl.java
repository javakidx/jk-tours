package idv.jk.service;

import idv.jk.ToursRepository;
import idv.jk.model.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {
    private final ToursRepository toursRepository;

    public TourServiceImpl(ToursRepository toursRepository) {
        this.toursRepository = toursRepository;
    }

    @Override
    public List<Tour> getAll() {
        return toursRepository.findAll();
    }
}
