package cat.udl.tidic.amb.calcularedat;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Person {
    private String fullName;
    private int year;
    private int month;
    private int day;

    public Person(String fullName, int year, int month, int day) {
        this.fullName = fullName;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Person() {
        this.fullName = "";
        this.year = 0;
        this.month = 0;
        this.day = 0;
    }

    private int getAge(){
        Calendar cal = Calendar.getInstance();
        Date today = new Date(cal.getTimeInMillis());
        cal.set(this.year,this.month,this.day);
        Date birthday = new Date(cal.getTimeInMillis());

        DateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.US);
        int d1 = Integer.parseInt(formatter.format(birthday));
        int d2 = Integer.parseInt(formatter.format(today));
        return (d2 - d1) / 10000;
    }

    @NonNull
    @Override
    public String toString(){

        return "Hola, em dic " + this.fullName + ". Vaig neixer el dia " + this.day + "/" +
                this.month + "/" + year + ". Tinc " + this.getAge() + " anys.";
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
