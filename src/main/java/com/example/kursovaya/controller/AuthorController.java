package com.example.kursovaya.controller;

import com.example.kursovaya.domain.Author;
import com.example.kursovaya.domain.Book;
import com.example.kursovaya.service.AuthorService;
import com.example.kursovaya.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("api/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping("{id}")
    public Author getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @PostMapping
    public Author create(@RequestBody Author book) {
        return authorService.createOrUpdate(book);
    }

    @PutMapping
    public Author update(@RequestBody Author book) {
        return authorService.createOrUpdate(book);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

    @GetMapping("all")
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GetMapping("{id}/books")
    public List<Book> getBooks(@PathVariable Long id) {
        return bookService.getByAuthorId(id);
    }
}
