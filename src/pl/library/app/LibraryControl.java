package pl.library.app;

import pl.library.io.DataReader;
import pl.library.model.Book;
import pl.library.model.Library;
import pl.library.model.Magazin;

public class LibraryControl {

    private static final int EXIT =0;
    private static final int ADD_BOOK =1;
    private static final int SHOW_BOOK =2;
    private static final int ADD_MAGAZINE =3;
    private static final int SHOW_MAGAZINE =4;

    private DataReader dataReader= new DataReader();
    private Library library = new Library();

    public void controlLoop(){

            Option option;

            do {

            printOptions();
            option= Option.createFromInt(dataReader.getInt());

            switch (option){
                case ADD_BOOK:
                    addBook();
                    break;
                case SHOW_BOOK:
                    printBooks();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case SHOW_MAGAZINE:
                    printMagazins();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Try again...");

            }

            } while (option!= Option.EXIT);
    }

    private void printMagazins() {
        library.printMagazines();
    }

    private void addMagazine() {
        Magazin magazin=dataReader.readAndCreateMagazine();
        library.addMagazine(magazin);

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
        for (Option value : Option.values()) {
            System.out.println(value);
        }


    }
}
