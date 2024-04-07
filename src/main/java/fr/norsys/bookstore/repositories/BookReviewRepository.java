package fr.norsys.bookstore.repositories;

import fr.norsys.bookstore.entities.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
    List<BookReview> findByUserId(Long userId);
}
