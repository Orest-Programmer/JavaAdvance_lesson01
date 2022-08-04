package ua.lviv.lgs;

public enum Days {
    SUNDAY("Неділя"),
    MONDAY("Понеділок"),
    TUESDAY("Вівторок"),
    WEDNESDAY("Середа"),
    THURSDAY("Четвер"),
    FRIDAY("П'ятниця"),
    SATURDAY("Субота");

    private final String title;

    Days(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
