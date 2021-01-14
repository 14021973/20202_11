package pl.library.io.file;

import pl.library.exception.DataExportException;
import pl.library.exception.DataImportException;
import pl.library.exception.InvalidDataException;
import pl.library.model.Book;
import pl.library.model.Library;
import pl.library.model.Magazin;
import pl.library.model.Publication;

import java.io.*;
import java.util.Scanner;

public class CsvFileManager implements FileManager{
    private static final String FILE_NAME = "Library.csv";

    @Override
    public Library importData() {
        Library library=new Library();
        try (Scanner fileReader= new Scanner(new File(FILE_NAME))) {
            while (fileReader.hasNextLine()){
                String line= fileReader.nextLine();
                Publication publication=createObjectFromString(line);
                library.addPublication(publication);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku do importu " + FILE_NAME);
        }
        return library;
    }

    private Publication createObjectFromString(String line) {
        String[] split=line.split(";");
        String type=split[0];
        if (Book.TYPE.equals(type)){
            return createBook(split);
        } else if (Magazin.TYPE.equals(type)){
            return createMagazine(split);
        }
        throw new InvalidDataException("Nieznany typ publikacji" + type);
    }

    private Magazin createMagazine(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        int month = Integer.valueOf(data[4]);
        int day = Integer.valueOf(data[5]);
        String language = data[6];
        return new Magazin(title, publisher, language, year, month, day);
    }

    private Book createBook(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        String author = data[4];
        int pages = Integer.valueOf(data[5]);
        String isbn = data[6];
        return new Book(title, author, year, pages, publisher, isbn);
    }

    @Override
    public void exportData(Library library) {
        Publication[] publications = library.getPublications();
        try (FileWriter fileWriter = new FileWriter(FILE_NAME);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Publication publication : publications) {
                bufferedWriter.write(publication.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku " + FILE_NAME);
        }

    }
}
