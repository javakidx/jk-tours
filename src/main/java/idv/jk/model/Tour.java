package idv.jk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("tours")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tour {
    @Id
    private String id;
    private String name;
    private String slug;
    private int duration;
    private int maxGroupSize;
    private Difficulty difficulty;
    private double ratings;
    private int ratingsQuantities;
    private double priceDiscount;
    private String summary;
    private String description;
    private String imageCover;
    private List<String> images;
    private Date createdAt;
    private Date startDate;
    private Date endDate;
    private boolean isSecret;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMaxGroupSize() {
        return maxGroupSize;
    }

    public void setMaxGroupSize(int maxGroupSize) {
        this.maxGroupSize = maxGroupSize;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public int getRatingsQuantities() {
        return ratingsQuantities;
    }

    public void setRatingsQuantities(int ratingsQuantities) {
        this.ratingsQuantities = ratingsQuantities;
    }

    public double getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(double priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageCover() {
        return imageCover;
    }

    public void setImageCover(String imageCover) {
        this.imageCover = imageCover;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isSecret() {
        return isSecret;
    }

    public void setSecret(boolean secret) {
        isSecret = secret;
    }
}
