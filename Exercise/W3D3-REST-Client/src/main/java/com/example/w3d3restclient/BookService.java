package com.example.w3d3restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private RestTemplate restTemplate;
    private final String bookUrl = "http://localhost:8080/books/{id}";
    private final String booksUrl = "http://localhost:8080/books";


    public Book get(Long id) {
        return restTemplate.getForObject(bookUrl, Book.class, id);
    }


    public List<Book> getAll() {
        ResponseEntity<List<Book>> books = restTemplate.exchange(booksUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Book>>() {});
        return books.getBody();
    }


    public void add(Book book) {
        restTemplate.postForLocation(booksUrl, book);
    }


    public void update(Book book) {
        restTemplate.put(bookUrl, book, book.getId());

    }
    public void delete(Long id) {
        restTemplate.delete(bookUrl, id);
    }
}
