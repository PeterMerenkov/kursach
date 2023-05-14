package com.example.kursovaya.service;

import com.example.kursovaya.domain.BookCompilation;

import java.util.List;

public interface BookCompilationService {
    BookCompilation getById(Long id);

    BookCompilation createOrUpdate(BookCompilation book);

    void delete(Long id);

    List<BookCompilation> getAll();
}
