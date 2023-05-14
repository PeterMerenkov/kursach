package com.example.kursovaya.repo;

import com.example.kursovaya.domain.BookCompilation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCompilationRepo extends JpaRepository<BookCompilation, Long> {
}
