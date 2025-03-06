package com.example.atividadeBook.controller;

import com.example.atividadeBook.domain.Book;
import com.example.atividadeBook.enums.StatusLivro;
import com.example.atividadeBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book){
      Book createdbook = service.create(book);
      return ResponseEntity.ok(createdbook);
    };

    @GetMapping
    public List<Book> findAll(){
        return service.findAll();
    };

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book foundBook = service.findById(id);
        return ResponseEntity.ok(foundBook);
    };

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book){
        Book updatedBook =  service.update(id, book);
        return ResponseEntity.ok(updatedBook);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    };

    @GetMapping("/status/{statusLivro}")
    public ResponseEntity<List<Book>> findAllDisponivel(@PathVariable StatusLivro statusLivro){
        List<Book> foundBook = service.findDisponivel(statusLivro);
        return ResponseEntity.ok(foundBook);
    }
}
