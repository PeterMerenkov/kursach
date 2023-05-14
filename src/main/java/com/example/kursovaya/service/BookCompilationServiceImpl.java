package com.example.kursovaya.service;

import com.example.kursovaya.domain.BookCompilation;
import com.example.kursovaya.repo.BookCompilationRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookCompilationServiceImpl implements BookCompilationService {
    private final BookCompilationRepo bookCompilationRepo;

    @Override
    public BookCompilation getById(Long id) {
        return bookCompilationRepo.findById(id).orElseThrow(() ->
                new RuntimeException(String.format("Не удалось найти подборку книг с id=%s", id)));
    }

    @Override
    public BookCompilation createOrUpdate(BookCompilation book) {
        return bookCompilationRepo.save(book);
    }

    @Override
    public void delete(Long id) {
        bookCompilationRepo.deleteById(id);
    }

    @Override
    public List<BookCompilation> getAll() {
        return bookCompilationRepo.findAll();
    }
}