package pl.library.model;

public class Library {

    private final int maxbooks  =   1000;
    private Book [] books    =   new Book[maxbooks];
    private int booksnumber =   0;

    public void addBook(Book book){

    if(booksnumber<maxbooks){
        books[booksnumber]=book;
        booksnumber++;    }
    else {
        System.out.println("Nie możesz dodaćjużżadnej książki");
        }

    }

    public void printBooks(){

        if (booksnumber==0){
            System.out.println("Brak książek do wyświetlenia");
                            }
        for (int i = 0; i < booksnumber; i++) {
        books[i].printInfo();
            
        }

    }

}
