package demo.springboot.service.impl;

import demo.springboot.model.Book;
import demo.springboot.model.BookRepository;
import demo.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book insertByBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = bookRepository.findOne(id);
        bookRepository.delete(book);
        return book;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }
}
