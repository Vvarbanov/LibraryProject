package com.uni.library.service;

import com.uni.library.dto.BookDTO;
import com.uni.library.model.Book;
import com.uni.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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

    public Set<String> getAllGenres(){
        Set<String> genreSet = new TreeSet<>();

        List<Book> books = (List<Book>) bookRepository.findAll();
        for (Book currentBook: books) {
            genreSet.add(currentBook.getGenre());
        }

        return genreSet;
    }

    public List<Book> getAllBooksByGenre(String genre) {
        Set<String> genres = getAllGenres();
        List<Book> booksByGenre = new ArrayList<>();
        if (genres.contains(genre)) {
            booksByGenre = bookRepository.findAllByGenre(genre);
        }
        return booksByGenre;
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public Long insertBook(BookDTO bookDTO) {
        Long id = null;
        if (bookDTO != null) {
            Book newBook = new Book();

            newBook.setDate(bookDTO.getDate());
            newBook.setGenre(bookDTO.getGenre());
            newBook.setAuthor(bookDTO.getAuthor());
            newBook.setName(bookDTO.getName());

            id = bookRepository.save(newBook).getId();
        }

        return id;
    }

    @Transactional
    public Long updateBookById(Long id, BookDTO updateBook) {
        if (bookRepository.findById(id).isPresent() && updateBook != null) {
            Book newBook = new Book();

            newBook.setId(id);
            newBook.setName(updateBook.getName());
            newBook.setAuthor(updateBook.getAuthor());
            newBook.setGenre(updateBook.getGenre());

            return bookRepository.save(newBook).getId();
        }
        return null;
    }

}
