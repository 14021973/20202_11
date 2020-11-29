package pl.library.app;

import pl.library.model.Book;

class Library {
     public static void main(String[] args) {
        final String appName = "Biblioteka v0.7";


        Book[] books=new Book[1000];
        books[0]=new Book("W pustyni i w puszczy","Henryk Sienkiewicz",2010,296,"Greg","9788373271890");
        books[1]=new Book("ABC gotowania","Jan Kowalski",2011,29,"ABC","123353453466");
        books[2]=new Book("Hitman","Henryk Sienkiewicz",2015,333,"Greg");

        System.out.println(appName);
        System.out.println("Książki dostępne w bibliotece");
        books[0].printInfo();
        books[1].printInfo();
        books[2].printInfo();
    }
}
