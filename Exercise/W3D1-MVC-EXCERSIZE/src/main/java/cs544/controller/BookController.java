package cs544.controller;

import cs544.entity.Book;
import cs544.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    public BookService bookService;


    @GetMapping("/")
    public String redirectRoot() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getAll(Model model) {
        List<Book> books=bookService.getAll();
        model.addAttribute("books", books);
        return "bookList";
    }
    @PostMapping("/books")
    public String addBook(Book book)
    {
        bookService.addBook(book);
        return "redirect:/books";
    }
    @GetMapping("/books/add")
    public String viewAdd(@ModelAttribute Book book, Model model) {
        model.addAttribute("msg", "Add");
        return "bookDetail";
    }
    @GetMapping("/books/{id}")
    public String getById(@PathVariable Long id,Model model)
    {
        model.addAttribute("book",bookService.get(id));
        model.addAttribute("msg", "Update");
        return "bookDetail";
    }

    @PostMapping("/books/{id}")
    public String update(Book book, @PathVariable int id) {
        bookService.update(book); // car.id already set by binding
        return "redirect:/books";
    }

    @PostMapping(value="/books/delete")
    public String delete(Long bookId) {
        bookService.delete(bookId);
        return "redirect:/books";
    }
}

