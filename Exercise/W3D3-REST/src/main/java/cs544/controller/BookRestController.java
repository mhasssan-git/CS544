package cs544.controller;

import cs544.entity.Book;
import cs544.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class BookRestController {
    @Autowired
    public BookService bookService;

    @GetMapping(value = "/books", produces = "application/json")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping(value = "/books/{id}", produces = "application/json")
    public Book get(@PathVariable int id) {
        return bookService.get((long) id);
    }

    @PostMapping(value = "/books", consumes = "application/json")
    public RedirectView add(@RequestBody Book book) {
        bookService.addBook(book);
        return new RedirectView("/books");
    }

    @PutMapping(value = "/books/{id}", consumes = "application/json")
    public void update(@PathVariable int id, @RequestBody Book book) {
        if (id != book.getId()) throw new IllegalArgumentException();
        bookService.update(book);
    }

    @DeleteMapping(value = "/books/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete((long) id);
    }
}
