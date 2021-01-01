package pl.library.model;

public class Library {

    private static final int MAX_PUBLICATIONS = 200;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];
    private int publication_number = 0;


    public Publication[] getPublications() {
        Publication[] result=new Publication[publication_number];
        for (int i = 0; i < result.length; i++) {
            result[i]=publications[i];
        }
        return result;
    }

    public void addBook(Book book) {

        addPublication(book);
    }

    public void addMagazine(Magazin magazin) {

        addPublication(magazin);
    }

public void addPublication(Publication publication){

        if (publication_number>=MAX_PUBLICATIONS){
            throw new ArrayIndexOutOfBoundsException("Max publications" );
        }
    publications[publication_number] = publication;
    publication_number++;
    }
}







