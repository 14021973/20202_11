package pl.library.model;

import java.util.Objects;

public class Magazin extends  Publication{

    public static final String TYPE="Magazyn";

    private int month;
    private int day;
    private String language;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Magazin(String title, String publisher, String language, int releaseDate, int month, int day) {

        super(title,releaseDate,publisher);
        this.month = month;
        this.day = day;
        this.language = language;
    }

    @Override
    public String toCsv() {
        return (TYPE + ";") +
                getTitle() + ";" +
                getPublisher() + ";" +
                getReleaseDate() + ";" +
                month + ";" +
                day + ";" +
                language + "";
    }

    @Override
    public String toString() {
        return "Magazin{" +
                "month=" + month +
                ", day=" + day +
                ", language='" + language + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazin magazin = (Magazin) o;
        return month == magazin.month && day == magazin.day && Objects.equals(language, magazin.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), month, day, language);
    }
}
