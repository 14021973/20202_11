package pl.library.app;

import pl.library.io.DataReader;
import pl.library.model.Book;
import pl.library.model.Library;

public class LibraryControl {

    private final int exit=0;
    private final int add=1;
    private final int show=2;

    private DataReader dataReader= new DataReader();
    private Library library = new Library();

    public void controlLoop(){

            int option;

            do {

            printOptions();
            option= dataReader.getInt();

            switch (option){
                case add:
                    addBook();
                    break;
                case show:
                    printBooks();
                    break;
                case exit:
                    exit();
                    break;
                default:
                    System.out.println("Try again...");

            }

            } while (option!=exit);
    }

    private void exit() {
        System.out.println("Bye");
        dataReader.close();
    }

    private void printBooks() {

        library.printBooks();
    }

    private void addBook() {
        Book book=dataReader.readAndCreateBook();
        library.addBook(book);

    }

    private void printOptions() {

        System.out.println("Wybierz opcje :");
        System.out.println(exit + " - wyjście");
        System.out.println(add + " - dodaj nową ksążke");
        System.out.println(show + " - wyświetl książki");

    }
}
