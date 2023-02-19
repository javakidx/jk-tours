package idv.jk.transformer;

import idv.jk.model.Difficulty;
import idv.jk.model.Tour;
import idv.jk.model.TourRequest;
import idv.jk.validator.ValidDifficulty;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TourTransformer implements Transformer<TourRequest, Tour> {
    @Override
    public Tour transform(TourRequest tourRequest) {
        final var tour = new Tour();
        tour.setName(tourRequest.getName());
        tour.setDuration(tourRequest.getDuration());
        tour.setMaxGroupSize(tourRequest.getMaxGroupSize());
        tour.setDifficulty(Difficulty.valueOf(tourRequest.getDifficulty().toUpperCase()));
        tour.setRatings(tourRequest.getRatings());
        tour.setPrice(tourRequest.getPrice());
        tour.setDescription(tourRequest.getDescription());
        tour.setImages(tourRequest.getImages());
        tour.setStartDate(tourRequest.getStartDate());
        tour.setEndDate(tourRequest.getEndDate());
        return tour;
    }
}
