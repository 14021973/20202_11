package pl.library.io.file;

import pl.library.exception.NoSuchFileException;
import pl.library.io.ConsolePrinter;
import pl.library.io.DataReader;


public class FileManagerBuilder {
    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }
    public FileManager build (){
        printer.printLine("Wybierz format danych");
        FileType fileType=getFileType();
        switch (fileType) {
            case SERIAL:
                return new SerializableFileManager();
            case CSV:
                return new CsvFileManager();
            default:
                throw new NoSuchFileException("Nieobsługiwany typ danych");
        }
    }

    private FileType getFileType() {
        boolean typeOk=false;
        FileType result=null;
        do {
            printTypes();
            //serial,SERIAL
            String type = reader.getString().toUpperCase();
            try
            {
                 result = FileType.valueOf(type);
                 typeOk=true;
            } catch(IllegalArgumentException e)
            {
                printer.printLine("Nieobsługiwany typ pliku");
            }
        } while(!typeOk);
        return  result;
    }

    private void printTypes() {
        for (FileType value : FileType.values()) {
           printer.printLine(value.name());
        }
    }
}
