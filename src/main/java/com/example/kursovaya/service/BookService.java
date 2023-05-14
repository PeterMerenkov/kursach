package com.example.kursovaya.service;

import com.example.kursovaya.domain.Book;

import java.util.List;

public interface BookService {
    Book getById(Long id);

    Book createOrUpdate(Book book);

    void delete(Long id);

    List<Book> getAll();

    void deleteAllByAuthorId(Long id);

    List<Book> getByAuthorId(Long id);
}
