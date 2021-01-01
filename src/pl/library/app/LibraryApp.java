package pl.library.app;

public class LibraryApp {

    private final static String APP_NAME="Biblioteka ver=1.4";

    public static void main(String[] args) {

        System.out.println(APP_NAME);

        LibraryControl libraryControl = new LibraryControl();

        libraryControl.controlLoop();
    }
}
 