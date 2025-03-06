package com.example.atividadeBook.repository;

import com.example.atividadeBook.domain.Book;
import com.example.atividadeBook.enums.StatusLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByStatusLivro(StatusLivro statusLivro);
}
