package com.example.kursovaya.service;

import com.example.kursovaya.domain.Book;
import com.example.kursovaya.repo.BookRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;

    @Override
    public Book getById(Long id) {
        return bookRepo.findById(id).orElseThrow(() ->
                new RuntimeException(String.format("Не удалось найти книгу с id=%s", id)));
    }

    @Override
    public Book createOrUpdate(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public void deleteAllByAuthorId(Long id) {
        bookRepo.deleteAllByAuthorId(id);
    }

    @Override
    public List<Book> getByAuthorId(Long id) {
        return bookRepo.getBookListByAuthorId(id);
    }
}




