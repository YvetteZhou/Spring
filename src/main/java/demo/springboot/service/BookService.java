package demo.springboot.service;

import demo.springboot.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(Long id);

    Book insertByBook(Book book);

    Book update(Book book);

    Book delete(Long id);
}
