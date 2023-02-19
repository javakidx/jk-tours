package idv.jk.controller;

import idv.jk.model.Tour;
import idv.jk.model.TourRequest;
import idv.jk.service.TourService;
import idv.jk.transformer.Transformer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tours")
public class ToursController {
    private final TourService tourService;
    private final Transformer<TourRequest, Tour> transformer;

    public ToursController(TourService tourService, Transformer<TourRequest, Tour> transformer) {
        this.tourService = tourService;
        this.transformer = transformer;
    }

    @PostMapping("")
    public Tour addTour(@Valid @RequestBody TourRequest tourRequest) {
        final var tour = transformer.transform(tourRequest);
        return tourService.createTour(tour);
    }

    @GetMapping("")
    public List<Tour> getAll() {
        return tourService.getAll();
    }

    @GetMapping("/{id}")
    public Tour getTour(@PathVariable String id) {
        return tourService.getById(id);
    }

    @PutMapping("/{id}")
    public Tour updateTour(@PathVariable String id, @Valid @RequestBody TourRequest request) {
        final var tour = transformer.transform(request);
        return tourService.updateTour(id, tour);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTour(@PathVariable String id) {
        tourService.deleteTour(id);
        return ResponseEntity.status(204).build();
    }
}
