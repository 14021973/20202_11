package pl.library.model;

public class Publication {
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

    public void printInfo(){}

}
