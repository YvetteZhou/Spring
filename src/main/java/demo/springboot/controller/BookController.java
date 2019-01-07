package demo.springboot.controller;

import demo.springboot.model.Book;
import demo.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public String getBookList(ModelMap map) {
        map.addAttribute("bookList", bookService.findAll());
        return "bookList";
    }

    @GetMapping(value = "/create")
    public String createBookForm(ModelMap map) {
        map.addAttribute("book", new Book());
        map.addAttribute("action", "create");
        return "bookForm";
    }

    @PostMapping(value = "/create")
    public String postBook(@ModelAttribute Book book) {
        bookService.insertByBook(book);
        return "redirect:/book";
    }

    @GetMapping(value = "/update/{id}")
    public String getBookByUser(@PathVariable Long id, ModelMap map) {
        map.addAttribute("book", bookService.findById(id));
        map.addAttribute("action", "update");
        return "bookForm";
    }

    @PostMapping(value = "/update")
    public String updateBook(@ModelAttribute Book book) {
        bookService.update(book);
        return "redirect:/book";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/book";
    }
}
