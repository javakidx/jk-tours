package idv.jk.model;

import idv.jk.validator.ValidDifficulty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TourRequest {
    @NotBlank(message = "Name is required.")
    private String name;
    private int duration;
    private int maxGroupSize;
    @ValidDifficulty
    @NotBlank
    private String difficulty;
    private double ratings;
    private double price;
    private String description;
    private List<String> images;
    private Date startDate;
    private Date endDate;
}
