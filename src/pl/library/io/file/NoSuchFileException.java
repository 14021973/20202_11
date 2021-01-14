package pl.library.io.file;

public class NoSuchFileException extends RuntimeException{
    public NoSuchFileException(String message) {
        super(message);
    }
}
