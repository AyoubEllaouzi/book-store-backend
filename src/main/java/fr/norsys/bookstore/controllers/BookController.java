package fr.norsys.bookstore.controllers;

import fr.norsys.bookstore.constants.BookReviewConstants;
import fr.norsys.bookstore.dto.ResponseDto;
import fr.norsys.bookstore.entities.Book;
import fr.norsys.bookstore.services.impl.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:5173")
@Validated
public class BookController {
    private BookService bookService;

    @PostMapping
    public ResponseEntity<ResponseDto> saveAuthor(@Valid @RequestBody Book room) {
        bookService.saveBook(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(BookReviewConstants.STATUS_201,BookReviewConstants.MESSAGE_201));


    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateAuthor(@PathVariable Long id, @Valid @RequestBody Book updatedRoom) {
        bookService.updateBook(id, updatedRoom);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(BookReviewConstants.STATUS_200,BookReviewConstants.MESSAGE_200));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteAuthor(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(BookReviewConstants.STATUS_200,BookReviewConstants.MESSAGE_200));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getAuthor(@PathVariable Long id) {
        Book room = bookService.getBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(room);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllAuthor() {
        List<Book> rooms = bookService.getAllBook();
        return ResponseEntity.status(HttpStatus.OK).body(rooms);
    }
}
