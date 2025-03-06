package com.example.atividadeBook.service;

import com.example.atividadeBook.enums.StatusLivro;
import com.example.atividadeBook.repository.BookRepository;
import com.example.atividadeBook.domain.Book;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book create(Book book){
        Book createdBook = bookRepository.save(book);
        return createdBook;
    };

    public Book findById(Long id){
        Book foundBook = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
        return foundBook;
    };

    public List<Book> findAll(){
        return bookRepository.findAll();
    }



    public Book update(Long id, Book book){
        Book updatedbook = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found"));

        updatedbook.setTitle(book.getTitle());
        updatedbook.setAuthor(book.getAuthor());
        updatedbook.setStatusLivro(book.getStatusLivro());

        bookRepository.save(updatedbook);
        return updatedbook;
    };

    public void delete(Long id){
        bookRepository.deleteById(id);
    };

    public List<Book> findDisponivel(StatusLivro statusLivro){
        List<Book> foundBook = bookRepository.findByStatusLivro(statusLivro);
        return foundBook;
    };

}
