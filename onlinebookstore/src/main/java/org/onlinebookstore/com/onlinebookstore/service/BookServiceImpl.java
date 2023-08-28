package org.onlinebookstore.com.onlinebookstore.service;

import org.onlinebookstore.com.onlinebookstore.entity.Book;
import org.onlinebookstore.com.onlinebookstore.entity.User;
import org.onlinebookstore.com.onlinebookstore.exception.ResourceNotFoundException;
import org.onlinebookstore.com.onlinebookstore.exception.UserNotAllowedException;
import org.onlinebookstore.com.onlinebookstore.repository.BookRepository;
import org.onlinebookstore.com.onlinebookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    public List<Book> getAllEntities() {
        return bookRepository.findAll();
    }

    @Override
    public Book createUpdateEntity(Book entity) {
        entity.setCreatedDate(new Date());
        return bookRepository.save(entity);
    }

    @Override
    public void deleteEntity(long id) {
        bookRepository.delete(getEntityById(id));
        ResponseEntity.ok();
    }

    @Override
    public Book getEntityById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent())
            return bookOptional.get();
        else
            throw new ResourceNotFoundException("Book not found");
    }

    @Override
    public String deleteBook(long userId, String bookId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        if (user.getUserType().equalsIgnoreCase("Admin")) {
            bookRepository.deleteById(bookId);
            return "Book Deleted Successfully";
        }else
            throw new UserNotAllowedException("User not allowed to delete book");
    }

    @Override
    public List<Book> getBookByCategory(String category) {
     return bookRepository.findByCategory(category);

    }

    @Override
    public Book getBookByBookName(String bookName) {
        return bookRepository.findByBookName(bookName).orElseThrow(() ->new ResourceNotFoundException("Book not Found with Name :"+bookName));
    }

    @Override
    public Book insertBook(long userId, Book book) {
       User user = userRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        if (user.getUserType().equalsIgnoreCase("Admin"))
            return bookRepository.save(book);
        else
            throw new UserNotAllowedException("User not allowed to insert book");
    }

}
