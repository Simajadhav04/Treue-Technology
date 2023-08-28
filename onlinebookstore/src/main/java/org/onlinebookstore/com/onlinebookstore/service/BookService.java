package org.onlinebookstore.com.onlinebookstore.service;

import org.onlinebookstore.com.onlinebookstore.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService extends BaseService<Book>{

    Book getBookByBookName(String bookName);

    Book insertBook(long userId, Book book);

    String deleteBook(long userId, String book);

    List<Book>getBookByCategory(String category);
}
