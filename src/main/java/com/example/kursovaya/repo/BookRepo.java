package com.example.kursovaya.repo;

import com.example.kursovaya.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
    @Modifying
    @Query("DELETE FROM Book book WHERE book.author.id = ?1")
    void deleteAllByAuthorId(Long id);

    @Query("SELECT book FROM Book book WHERE book.author.id = ?1")
    List<Book> getBookListByAuthorId(Long id);
}
