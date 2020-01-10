package com.uni.library.controller;

import com.uni.library.dto.BookDTO;
import com.uni.library.model.Book;
import com.uni.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RequestMapping("/books")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookByID(id);
    }

    @GetMapping("/genres")
    public Set<String> getAllGenres() {
        return bookService.getAllGenres();
    }

    @GetMapping("/genres/{genre}")
    public List<Book> getAllBooksByGenre(@PathVariable String genre) {
        return bookService.getAllBooksByGenre(genre);
    }

    @PostMapping
    public ResponseEntity insertBook(@NonNull @Valid @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.insertBook(bookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBookById(@PathVariable Long id, @Valid @NonNull @RequestBody BookDTO updateBook) {
        return ResponseEntity.ok(bookService.updateBookById(id, updateBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteBookById(id));
    }
}
