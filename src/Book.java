 class Book {

    String title ;
    String author ;
    int releaseDate ;
    int pages ;
    String publisher ;
    String isbn ;

    Book(String booktitle , String bookauthor , int bookreleaseDate ,  int bookpages ,  String bookpublisher ,  String bookisbn )
    {
title=booktitle;
author=bookauthor;
releaseDate=bookreleaseDate;
pages=bookpages;
publisher=bookpublisher;
isbn=bookisbn;
    }


     void prontInfo() {
       String info=title +" "+        author+" "+        releaseDate+" "+        pages+" "+        publisher+" "+        isbn;
        System.out.println(info);
    }
}


