package com.example.kursovaya.service;

import com.example.kursovaya.domain.Author;

import java.util.List;

public interface AuthorService {
    Author getById(Long id);

    Author createOrUpdate(Author book);

    void delete(Long id);

    List<Author> getAll();
}
