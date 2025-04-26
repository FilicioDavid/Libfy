package Controller;

import Model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    public static List<Book> books = new ArrayList<>();
    private static int nextId = 0;

    public static void addBook(String title, String author) {
        Book book = new Book(nextId++, title, author, true);
        books.add(book);
        System.out.println("Livro adicionado com sucesso");
    }

    public static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public static int generateId() {
        return nextId++;
    }

    public static Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
