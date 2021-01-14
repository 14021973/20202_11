package pl.library.app;

import pl.library.exception.DataExportException;
import pl.library.exception.DataImportException;
import pl.library.exception.NoSuchOptionException;
import pl.library.io.ConsolePrinter;
import pl.library.io.DataReader;
import pl.library.io.file.FileManager;
import pl.library.io.file.FileManagerBuilder;
import pl.library.model.Book;
import pl.library.model.Library;
import pl.library.model.Magazin;
import pl.library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {

    private static final int EXIT =0;
    private static final int ADD_BOOK =1;
    private static final int SHOW_BOOK =2;
    private static final int ADD_MAGAZINE =3;
    private static final int SHOW_MAGAZINE =4;

    private ConsolePrinter printer=new ConsolePrinter();
    private DataReader dataReader= new DataReader(printer);
    private FileManager fileManager;
    private Library library;

    LibraryControl (){
        fileManager = new FileManagerBuilder(printer,dataReader).build();
        try {
            library = fileManager.importData();
            printer.printLine("Zaimportowałem dane !!!");
        } catch (DataImportException e) {
            printer.printLine(e.getMessage());
            printer.printLine("Założyłem nową bazę");
            library= new Library();

        }

    }

    void controlLoop(){

            Option option;

            do {

            printOptions();
            option= getOption();

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
                    printer.printLine("Try again...");

            }

            } while (option!= Option.EXIT);
    }

    private void printOptions() {
        printer.printLine("Wybierz opcję: ");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private Option getOption() {
        boolean optionOK=false;
        Option option=null;
        while (!optionOK){
            try {
                option=Option.createFromInt(dataReader.getInt());
                optionOK=true;
            } catch(NoSuchOptionException e) {
                printer.printLine(e.getMessage());
            } catch(InputMismatchException e){
                printer.printLine("Wprowadzono nieliczbę");
            }
        }
            return option;

    }

    private void printMagazins() {
        Publication[] publications= library.getPublications();
        printer.printMagazines(publications);
    }

    private void addMagazine() {

        try {
            Magazin magazin=dataReader.readAndCreateMagazine();
            library.addMagazine(magazin);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyć magazynu, niepoprawne dane");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie można dodać kolejnego magazynu");
        }
    }

    private void exit() {
        try {
            fileManager.exportData(library);
            printer.printLine("Export OK ");
        } catch (DataExportException e){
            printer.printLine((e.getMessage()));
        }
        printer.printLine("Bye");
        dataReader.close();
        }



    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addBook(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyć książki, niepoprawne dane");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie można dodać kolejnej książki");
        }
    }
    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }
}
