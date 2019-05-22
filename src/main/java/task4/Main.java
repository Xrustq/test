package task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        Author author = new Author("qwe", 1, new ArrayList<>());
        Book book= new Book("wqe", 1,new ArrayList<>());
        books.add(book);
        authors.add(author);
        author.setBooks(books);
        book.setAuthors(authors);

        System.out.println(author);
    }
}
