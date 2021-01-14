package pl.library.model;

import java.io.Serializable;
import java.util.Objects;

public abstract  class Publication implements Serializable {
    private String title ;
    private int releaseDate ;
    private String publisher ;


    public Publication(String title, int releaseDate, String publisher) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public abstract  String toCsv();

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return releaseDate == that.releaseDate && Objects.equals(title, that.title) && Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate, publisher);
    }
}
