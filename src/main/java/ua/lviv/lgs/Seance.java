package ua.lviv.lgs;

public class Seance implements Comparable<Seance> {
    Movie movie;
    Time startTime;
    Time endTime;

    public  Seance (Movie movie, Time startTime){
        this.movie=movie;
        this.startTime = startTime;
        int min = startTime.getMin()+movie.duration.getMin();
        int hour = startTime.getHour()+movie.duration.getHour();
        if (min>=60){
            hour+=1;
            min = Math.abs(60-min);
            if (hour>24)
                hour=Math.abs(24-hour);
        }
        Time tempTime = new Time(min,hour);
        this.endTime =tempTime;

    }

    @Override
    public String toString() {
        return "Film " + movie +
                "  Seance start time:  " + startTime +
                "  Ending: " + endTime +
                ' ';
    }

    public int compareTo(Seance s) {
        return Integer.compare((movie.duration.getMin()+movie.duration.getHour()*60), (s.movie.duration.getMin()+s.movie.duration.getHour()*60));
    }
}
