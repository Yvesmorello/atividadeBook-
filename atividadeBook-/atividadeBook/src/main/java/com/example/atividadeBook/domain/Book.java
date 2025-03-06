package com.example.atividadeBook.domain;

import com.example.atividadeBook.enums.StatusLivro;
import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    @Enumerated(value = EnumType.ORDINAL)
    private StatusLivro statusLivro;


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public StatusLivro getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(StatusLivro statusLivro) {
        this.statusLivro = statusLivro;
    }

    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book() {
    }
}
