package fr.norsys.bookstore.services;

import fr.norsys.bookstore.entities.Book;
import fr.norsys.bookstore.entities.User;

import java.util.List;

public interface IBookService {
    void saveBook(Book book);
    void updateBook(Long id , Book book);
    void deleteBook(Long id);
    Book getBook(Long id);
    List<Book> getAllBook();
    public List<Book> searchUsersByUsername(String query);
}
