package fr.norsys.bookstore.services.impl;

import fr.norsys.bookstore.entities.Book;
import fr.norsys.bookstore.entities.BookReview;
import fr.norsys.bookstore.exceptions.ResourceNotFoundException;
import fr.norsys.bookstore.repositories.BookRepository;
import fr.norsys.bookstore.repositories.BookReviewRepository;
import fr.norsys.bookstore.services.IBookReviewService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class BookReviewService implements IBookReviewService {
    private BookReviewRepository bookReviewRepository;
    private BookRepository bookRepository;


    @Override
    public void reserveBookReview(BookReview reservation) {

    }

    /* public void reserveBookReview(BookReview bookReview) {
            Book book = bookReviewRepository.findById(bookReview.getBook().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("room id : "+bookReview.getBook().getId()));
            bookReviewRepository.save(reservation);
        }
    */
    @Override
    public void updateBookReview(Long id, BookReview updatedBookReview) {
        BookReview bookReview = bookReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BookReview id : "+id));

        bookReview.setUser(updatedBookReview.getUser());
        bookReview.setBook(updatedBookReview.getBook());
        bookReview.setReview(updatedBookReview.getReview());
        bookReview.setRating(updatedBookReview.getRating());
        bookReviewRepository.save(bookReview);
    }

    @Override
    public void deleteBookReview(Long id) {
        bookReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BookReview id : "+id));
        bookReviewRepository.deleteById(id);
    }

    @Override
    public BookReview getBookReview(Long id) {
        return bookReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BookReview id : "+id));
    }

    @Override
    public List<BookReview> getAllBookReview() {
        return bookReviewRepository.findAll();
    }
}
