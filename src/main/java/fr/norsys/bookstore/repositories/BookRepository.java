package fr.norsys.bookstore.repositories;

import fr.norsys.bookstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
