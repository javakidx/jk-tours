package idv.jk.controller;

import idv.jk.model.Tour;
import idv.jk.service.TourService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tours")
public class ToursController {
    private final TourService tourService;

    public ToursController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("")
    public List<Tour> getAll() {
        return tourService.getAll();
    }


    @GetMapping("/{id}")
    public String getTour(@PathVariable String id) {
        return String.format("The id is %s", id);
    }


}
