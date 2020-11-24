 class Library {
     public static void main(String[] args) {
        final String appName = "Biblioteka v0.4";

        Book book1=new Book("W pustyni i w puszczy","Henryk Sienkiewicz",2010,296,"Greg","9788373271890");
        Book book2=new Book("ABC gotowania","Jan Kowalski",2011,29,"ABC","123353453466");
        Book book3=new Book("Hitman","Henryk Sienkiewicz",2015,333,"Greg");

        System.out.println(appName);
        System.out.println("Książki dostępne w bibliotece");
        book1.prontInfo();
        book2.prontInfo();
        book3.prontInfo();
    }
}
