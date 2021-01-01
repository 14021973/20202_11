package pl.library.io;

import pl.library.model.Book;
import pl.library.model.Magazin;

import java.util.Scanner;

public class DataReader {

    private Scanner scanner=new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public Book readAndCreateBook() {

        printer.printLine("Podaj tytuł:");
        String tytul = scanner.nextLine();

        printer.printLine("Podaj autora:");
        String autor = scanner.nextLine();

        printer.printLine("Podaj rok wydania:");
        int rok = getInt();

        printer.printLine("Podaj liczbę stron:");
        int strony = getInt();

        printer.printLine("Podaj wydawnictwo:");
        String wydawnictwo = scanner.nextLine();

        printer.printLine("Podaj ISBN:");
        String isbn = scanner.nextLine();

        return new Book (tytul, autor, rok, strony, wydawnictwo, isbn);
    }

    public Magazin readAndCreateMagazine() {

        printer.printLine("Podaj tytuł:");
        String tytul = scanner.nextLine();

        printer.printLine("Podaj wydawnictow:");
        String wydawnictwo = scanner.nextLine();

        printer.printLine("Podaj język:");
        String jezyk = scanner.nextLine();

        printer.printLine("Podaj rok wydania:");
        int rok = getInt();

        printer.printLine("Podaj miesiac:");
        int miesiac = getInt();

        printer.printLine("Podaj dzień wydania:");
        int dzien = getInt();

        return new Magazin (tytul,  wydawnictwo, jezyk, rok, miesiac, dzien);
    }

    public int getInt(){
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }


    }

    public void close(){
        scanner.close();

    }
}
