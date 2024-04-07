package fr.norsys.bookstore.services;

import fr.norsys.bookstore.entities.BookReview;

import java.util.List;

public interface IBookReviewService {
    void saveLending(BookReview reservation);
    void updateBookReview(Long id, BookReview reservation);
    void deleteBookReview(Long id);
    BookReview getBookReview(Long id);
    List<BookReview> getAllBookReview();
    List<BookReview> getUserBooks(Long userId);
}
