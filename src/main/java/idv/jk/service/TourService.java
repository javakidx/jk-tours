package idv.jk.service;

import idv.jk.model.Tour;

import java.util.List;

public interface TourService {
    Tour getById(String id);
    List<Tour> getAll();

    Tour createTour(Tour tour);

    Tour updateTour(String id, Tour tour);

    void deleteTour(String id);
}
