package pl.pjatk.Lab4;

public class Movie {
    private static Long id = 0L;
    private final Long idL;
    private String title;
    private String category;
    private Long duration;

    public Movie(String title, String category, Long duration)
    {
        this.idL = id++;
        this.title = title;
        this.category = category;
        this.duration = duration;
    }

    public Movie()
    {
        this.idL = id++;
    }

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
}
