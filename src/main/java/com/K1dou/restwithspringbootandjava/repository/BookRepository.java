package com.K1dou.restwithspringbootandjava.repository;

import com.K1dou.restwithspringbootandjava.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
