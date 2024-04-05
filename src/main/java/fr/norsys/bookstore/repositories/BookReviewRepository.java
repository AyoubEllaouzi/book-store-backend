package fr.norsys.bookstore.repositories;

import fr.norsys.bookstore.entities.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
}
