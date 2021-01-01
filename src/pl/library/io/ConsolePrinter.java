package pl.library.io;

import pl.library.model.Book;
import pl.library.model.Magazin;
import pl.library.model.Publication;

public class ConsolePrinter {

    public void printBooks(Publication[] publications) {
        int countBooks = 0;
        for (Publication publication : publications) {

            if (publication instanceof Book) {
                System.out.println(publication);
                countBooks++;
            }
        }
        if (countBooks == 0) {
            printLine("Brak książek do wyświetlenia");
        }


    }

    public void printMagazines(Publication[] publications) {
        int countMagazines = 0;

        for (Publication publication : publications) {


            if (publication instanceof Magazin) {
                System.out.println(publication);
                countMagazines++;
            }
        }
        if (countMagazines == 0) {
            printLine("Brak magazynów do wyświetlenia");
        }
    }

    public void printLine(String text)
    {
        System.out.println(text);

    }
}
