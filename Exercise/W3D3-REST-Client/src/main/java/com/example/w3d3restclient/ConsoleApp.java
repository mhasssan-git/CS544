package com.example.w3d3restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleApp implements CommandLineRunner {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private BookService bookService;
    @Override
    public void run(String... args) throws Exception {
        Book p = bookService.get(1L);
        System.out.println("\n===================BEFORE INSERT======================");
        bookService.getAll().stream().forEach(a->System.out.println(a));
        bookService.add(new Book("0-340-01381-8", "a",2,"Test"));
        System.out.println("===================AFTER INSERT======================");
        bookService.getAll().stream().forEach(a->System.out.println(a));

        p.setPrice(33);
        bookService.update(p);
        System.out.println("===================AFTER UPDATE======================");
        bookService.getAll().stream().forEach(a->System.out.println(a));
        bookService.delete(2L);
        System.out.println("====================AFTER DELETE=====================");
        bookService.getAll().stream().forEach(a->System.out.println(a));
        p = bookService.getAll().get(0);
        System.out.println("=========================================\n");
        System.out.println(p.getTitle());

    }
}
