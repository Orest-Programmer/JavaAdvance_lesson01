package ua.lviv.lgs;

public class Time implements Comparable<Time>{
    int min;
    int hour;

    public int getMin() {
        return min;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public String toString() {
        return " Hour: " + hour +
                " Min: " + min;
    }


    public Time(int min, int hour) {
        if (min>=0 & min<=60)
            this.min = min;
        if (hour<=24 & hour>=0)
            this.hour = hour;
        else{
            try {
                throw new IllegalArgumentException();
            }
            catch (IllegalArgumentException exception){
                System.out.println("Hour in diapason 0-24 Min in 0-60 only! ");
            }
        }
    }


    @Override
    public int compareTo(Time o) {
        if (o.getHour()>getHour()) return 1;
        else if(o.getHour()==getHour()){
            if (o.getMin()>getMin())return 1;
            else return 0;
        }
        else return 0;
    }
}
