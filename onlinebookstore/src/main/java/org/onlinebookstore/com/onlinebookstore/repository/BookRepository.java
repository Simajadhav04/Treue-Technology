package org.onlinebookstore.com.onlinebookstore.repository;

import org.onlinebookstore.com.onlinebookstore.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends BaseRepository<Book>{
    Optional<Book> findByBookName(String bookName);


    List<Book> findByCategory(String category);
}
