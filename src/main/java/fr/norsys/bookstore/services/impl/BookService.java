package fr.norsys.bookstore.services.impl;

import fr.norsys.bookstore.entities.Book;
import fr.norsys.bookstore.exceptions.ResourceNotFoundException;
import fr.norsys.bookstore.repositories.BookRepository;
import fr.norsys.bookstore.services.IBookService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BookService implements IBookService {
    private BookRepository bookRepository;

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long id, Book updatedBook) {

        Book Book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book id : "+id));

        Book.setTitle(updatedBook.getTitle());
        Book.setGenre(updatedBook.getGenre());
        Book.setAuthor(updatedBook.getAuthor());
        bookRepository.save(Book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book id : "+id));
        bookRepository.deleteById(id);
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book id : "+id));

    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }
}
