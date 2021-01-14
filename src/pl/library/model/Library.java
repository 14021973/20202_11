package pl.library.model;

import java.io.Serializable;

public class Library implements Serializable {

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



public void addPublication(Publication publication){

        if (publication_number>=MAX_PUBLICATIONS){
            throw new ArrayIndexOutOfBoundsException("Max publications" );
        }
    publications[publication_number] = publication;
    publication_number++;
    }
}







