package pl.pjatk.RentalService;


public class Movie {
    private Long idL;
    private String title;
    private String category;
    private Long duration;
    private boolean isAvailable=false;

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

    public void setAvailable() { isAvailable = !isAvailable(); }
}