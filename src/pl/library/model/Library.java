package pl.library.model;

public class Library {

    private static final int MAX_PUBLICATIONS = 200;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];
    private int publication_number = 0;


    public void addBook(Book book) {

        if (publication_number < MAX_PUBLICATIONS) {
            publications[publication_number] = book;
            publication_number++;
        } else {
            System.out.println("Nie możesz dodaćjuż żadnej książki");
        }

    }

    public void addMagazine(Magazin magazin) {

        if (publication_number < MAX_PUBLICATIONS) {
            publications[publication_number] = magazin;
            publication_number++;
        } else {
            System.out.println("Nie możesz dodaćjuż żadnego magazynu");
        }

    }

    public void printBooks() {
        int countBooks = 0;
        for (int i = 0; i < publication_number; i++) {
            if (publications[i] instanceof Book) {
                publications[i].printInfo();
                countBooks++;
            }
        }
        if (countBooks == 0) {
            System.out.println("Brak książek do wyświetlenia");
        }


    }


    public void printMagazines() {
        int countMagazines = 0;

        for (int i = 0; i < publication_number; i++) {
            if (publications[i] instanceof Magazin) {
                publications[i].printInfo();
                countMagazines++;
            }
        }
        if (countMagazines == 0) {
            System.out.println("Brak magazynów do wyświetlenia");
        }


    }
}


