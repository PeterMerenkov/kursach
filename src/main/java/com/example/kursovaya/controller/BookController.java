package com.example.kursovaya.controller;

import com.example.kursovaya.domain.Book;
import com.example.kursovaya.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("{id}")
    public Book getById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.createOrUpdate(book);
    }

    @PutMapping
    public Book update(@RequestBody Book book) {
        return bookService.createOrUpdate(book);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping("all")
    public List<Book> getAll() {
        return bookService.getAll();
    }
}
