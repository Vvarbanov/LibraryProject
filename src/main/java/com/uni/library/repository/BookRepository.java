package com.uni.library.repository;

import com.uni.library.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAllByGenre(String genre);
}
