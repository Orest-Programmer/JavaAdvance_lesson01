package ua.lviv.lgs;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Supplier;

public class Cinema {
    TreeMap<Days, Schedule> schedules = new TreeMap<>();


    static Time open;
    static Time close;


    Cinema() {
        Arrays.stream(Days.values()).forEach(d->schedules.put(d,new Schedule()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Open time ");
        open = GetAll.getTime();
        System.out.println("Ending time: ");
        close = GetAll.getTime();
    }

    void getAllMovies(){
        HashSet<String> movieLibrary = new HashSet<>();
        Arrays.stream(Days.values()).forEach(day->{
            Schedule schedule = schedules.get(day);
            schedule.seances.forEach(seance->{
                movieLibrary.add(seance.movie.getTitle());
            });
        });
        movieLibrary.forEach(System.out::println);
    }

    void getScheduleForDay(){
        try{
            String day = GetAll.getDay();
            Schedule schedule = schedules.get(Days.valueOf(day.toUpperCase()));
            schedule.seances.forEach(System.out::println);}
        catch (IllegalArgumentException exception){
            System.out.println("You entered the day wrong. Try again please");
        }
    }

    void addSeance ( ) {
        String day = GetAll.getDay();
        try {
            Schedule schedule = schedules.get(Days.valueOf(day.toUpperCase()));
            schedule.addSeance();
        }
        catch (IllegalArgumentException exception){
            System.out.println("You entered the day wrong. Try again please");
        }

    }


    void removeMovie() {
        System.out.println("You are going to delete all seances with some movie.\nYou also " +
                "will delete this film from library");
        Movie movie = GetAll.getMovie();
        schedules.values().forEach((schedule) ->
                schedule.seances.removeIf(seance -> seance.movie.getTitle().equalsIgnoreCase(movie.getTitle())));
    }


    void removeSeance ( String day) {
        try {
            schedules.get(Days.valueOf(day.toUpperCase())).removeSeance();
        }
        catch (IllegalArgumentException exception){
            System.out.println("You entered the day wrong. Try again please");
        }
    }

}
