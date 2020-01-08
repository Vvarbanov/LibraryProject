package com.uni.library.service;

import com.uni.library.model.Book;
import com.uni.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks (){
        return (List<Book>) bookRepository.findAll();
    }

    public Book getBookByID(Long id) {
        if (bookRepository.findById(id).isPresent())
            return bookRepository.findById(id).get();
        return null;
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public void insertBookById(Book book) {
        bookRepository.save(book);
    }

    public void updateBookById(Long id, Book updateBook) {
        if (bookRepository.findById(id).isPresent()) {
            updateBook.setId(id);
            bookRepository.save(updateBook);
        }
    }
}
