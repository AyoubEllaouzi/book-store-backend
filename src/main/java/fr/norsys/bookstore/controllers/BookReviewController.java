package fr.norsys.bookstore.controllers;

import fr.norsys.bookstore.constants.BookReviewConstants;
import fr.norsys.bookstore.dto.ResponseDto;
import fr.norsys.bookstore.entities.BookReview;
import fr.norsys.bookstore.services.impl.BookReviewService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reviews")
@Validated
@CrossOrigin(origins = "http://localhost:5173")
public class BookReviewController {
    private BookReviewService bookReviewService;

    @PostMapping
    public ResponseEntity<ResponseDto> saveLending(@Valid @RequestBody BookReview bookReview) {
        bookReviewService.saveLending(bookReview);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(BookReviewConstants.STATUS_201,BookReviewConstants.MESSAGE_201));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateBookReview(@PathVariable Long id, @Valid @RequestBody BookReview updatedBookReview) {
        bookReviewService.updateBookReview(id, updatedBookReview);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(BookReviewConstants.STATUS_200,BookReviewConstants.MESSAGE_200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteBookReview(@PathVariable Long id) {
        bookReviewService.deleteBookReview(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(BookReviewConstants.STATUS_200,BookReviewConstants.MESSAGE_200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookReview> getBookReview(@PathVariable Long id) {
        BookReview bookReview = bookReviewService.getBookReview(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookReview);
    }

    @GetMapping
    public ResponseEntity<List<BookReview>> getAllBookReviews() {
        List<BookReview> bookReviews = bookReviewService.getAllBookReview();
        return ResponseEntity.status(HttpStatus.OK).body(bookReviews);
    }

    @GetMapping("library/{id}")
    public ResponseEntity<List<BookReview>> getUserBooks(@PathVariable Long id) {
        List<BookReview> bookReviews = bookReviewService.getUserBooks(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookReviews);
    }
}
