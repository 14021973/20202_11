package pl.library.app;

import pl.library.exception.DataExportException;
import pl.library.exception.DataImportException;
import pl.library.exception.InvalidDataException;
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
        } catch (DataImportException |InvalidDataException e) {
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
                case DELETE_BOOK:
                    deleteBook();
                    break;
                case DELETE_MAGAZINE:
                    deleteMagazine();
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
            library.addPublication(magazin);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyć magazynu, niepoprawne dane");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie można dodać kolejnego magazynu");
        }
    }
    private void deleteMagazine() {
        try {
            Magazin magazin = dataReader.readAndCreateMagazine();
            if (library.removePublication(magazin))
                printer.printLine("Usunięto magazyn");
            else
                printer.printLine("Nie udało się usunąć magazynu");
        } catch (InputMismatchException e){
            printer.printLine("Nie udało się usunąć wskazanego magazynu");
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
            library.addPublication(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyć książki, niepoprawne dane");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie można dodać kolejnej książki");
        }
    }

    private void deleteBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            if (library.removePublication(book))
                printer.printLine("Usunięto książkę");
            else
                printer.printLine("Nie udało się usunąć książki");
        } catch (InputMismatchException e){
            printer.printLine("Nie udało się usunąć wskazanej książki");
        }
    }


    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }


    private enum Option {
        EXIT(0, "Wyjście z programu"),
        ADD_BOOK(1, "Dodanie książki"),
        ADD_MAGAZINE(2,"Dodanie magazynu/gazety"),
        SHOW_BOOK(3, "Wyświetlenie dostępnych książek"),
        SHOW_MAGAZINE(4, "Wyświetlenie dostępnych magazynów/gazet"),
        DELETE_BOOK(5, "Usuń książkę"),
        DELETE_MAGAZINE(6, "Usuń magazyn");

        private int value;
        private String description;

        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch(ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id " + option);
            }
        }
    }
}
