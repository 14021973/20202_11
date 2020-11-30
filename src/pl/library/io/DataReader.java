package pl.library.io;

import pl.library.model.Book;
import java.util.Scanner;

public class DataReader {

    private Scanner scanner=new Scanner(System.in);

    public Book readAndCreateBook() {

        System.out.println("Podaj tytuł:");
        String tytul = scanner.nextLine();

        System.out.println("Podaj autora:");
        String autor = scanner.nextLine();

        System.out.println("Podaj rok wydania:");
        int rok = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj liczbę stron:");
        int strony = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj wydawnictwo:");
        String wydawnictwo = scanner.nextLine();

        System.out.println("Podaj ISBN:");
        String isbn = scanner.nextLine();

        return new Book(tytul, autor, rok, strony, wydawnictwo, isbn);
    }

    public int getInt(){

        int number= scanner.nextInt();
        scanner.nextLine();
        return  number;

    }

    public void close(){
        scanner.close();

    }
}
