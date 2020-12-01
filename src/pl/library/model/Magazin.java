package pl.library.model;

public class Magazin extends  Publication{

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
        this.setTitle(title);
        this.setPublisher(publisher);
        this.setReleaseDate(releaseDate);
        this.month = month;
        this.day = day;
        this.language = language;
    }

    public  void printInfo(){

        String info=getTitle() +"; "+ getPublisher() +"; "+    getReleaseDate()+"; "+ month +"; "+ day +"; "+language;


        System.out.println(info);
    }
}
