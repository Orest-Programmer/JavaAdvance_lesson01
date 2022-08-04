package ua.lviv.lgs;

public class Movie {
    String title;
    Time duration;


    public Movie(String title, Time duration) {
        this.title = title;
        this.duration = duration;

    }

    @Override
    public String toString() {
        return "Name:  " + title  +
                "  Duration: " + duration;
    }

    public String getTitle() {
        return title;
    }
}
