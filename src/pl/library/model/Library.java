package pl.library.model;

public class Library {

    private static final int MAXBOOKS =   100;
    private static final int MAXMAGAZINES =   100;


    private Book [] books    =   new Book[MAXBOOKS];
    private Magazin [] magazines    =   new Magazin[MAXMAGAZINES];
    private int booksnumber =   0;
    private int magazinenumber =   0;

    public void addBook(Book book){

    if(booksnumber< MAXBOOKS){
        books[booksnumber]=book;
        booksnumber++;    }
    else {
        System.out.println("Nie możesz dodaćjuż żadnej książki");
        }

    }

    public void addMagazine(Magazin magazin){

        if(magazinenumber< MAXMAGAZINES){
            magazines[magazinenumber]=magazin;
            magazinenumber++;    }
        else {
            System.out.println("Nie możesz dodaćjuż żadnego magazynu");
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

    public void printMagazines(){

        if (magazinenumber==0){
            System.out.println("Brak magazynów do wyświetlenia");
        }
        for (int i = 0; i < magazinenumber; i++) {
            magazines[i].printInfo();

        }

    }

}
