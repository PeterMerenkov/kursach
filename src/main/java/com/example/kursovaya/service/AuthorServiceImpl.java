package com.example.kursovaya.service;

import com.example.kursovaya.domain.Author;
import com.example.kursovaya.repo.AuthorRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepo authorRepo;
    private final BookService bookService;

    @Override
    public Author getById(Long id) {
        return authorRepo.findById(id).orElseThrow(() ->
                new RuntimeException(String.format("Не удалось найти автора с id=%s", id)));
    }

    @Override
    public Author createOrUpdate(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public void delete(Long id) {
        bookService.deleteAllByAuthorId(id);
        authorRepo.deleteById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorRepo.findAll();
    }
}