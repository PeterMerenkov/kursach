package com.example.kursovaya.controller;

import com.example.kursovaya.domain.Author;
import com.example.kursovaya.domain.Book;
import com.example.kursovaya.domain.BookCompilation;
import com.example.kursovaya.service.BookCompilationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("api/book-compilation")
@RequiredArgsConstructor
public class BookCompilationController {
    private final BookCompilationService bookCompilationService;

    @GetMapping("{id}")
    public BookCompilation getById(@PathVariable Long id) {
        return bookCompilationService.getById(id);
    }

    @PostMapping
    public BookCompilation create(@RequestBody BookCompilation book) {
        return bookCompilationService.createOrUpdate(book);
    }

    @PutMapping
    public BookCompilation update(@RequestBody BookCompilation book) {
        return bookCompilationService.createOrUpdate(book);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        bookCompilationService.delete(id);
    }

    @GetMapping("all")
    public List<BookCompilation> getAll() {
        return bookCompilationService.getAll();
    }
}
