package pl.pjatk.Lab4;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Schema(description = "Details about a movie available")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Schema(description = "The unique ID of the movie", example = "1")
    private Long idL;
    @Schema(description = "The title of the movie", example = "Interstellar", required = true)
    private String title;
    @Schema(description = "The category of the movie (e.g., Sci-Fi, Drama, Comedy)", example = "Sci-Fi")
    private String category;
    @Schema(description = "Movie duration in minutes", example = "156 means 156 minutes", required = true)
    private Long duration;
    @Schema(description = "Availability status of the movie", example = "true", required = true)
    private  boolean isAvailable=false;

    public Movie(String title, String category, Long duration)
    {
        this.title = title;
        this.category = category;
        this.duration = duration;
    }

    public Movie() {}

    public Long getId() {
        return idL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public boolean isAvailable() { return isAvailable; }

    public void setAvailable() { this.isAvailable = true; }

    public void setUnavailable() { this.isAvailable = false; }
}
