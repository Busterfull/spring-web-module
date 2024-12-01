package ru.edu.springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.edu.springweb.dto.BookDto;
import ru.edu.springweb.entity.Book;
import ru.edu.springweb.service.BookService;

import java.util.List;

@Controller
@RequestMapping(value ="/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Autowired
    private  ConversionService conversionService;
    @Autowired
    private  BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable("id") Long id) {
        Book book = bookService.getBook(id);
        return ResponseEntity.ok(conversionService.convert(book, BookDto.class));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks() {
        List<Book> books = bookService.getBooks();
        List<BookDto> dtos = books.stream()
                        .map(b -> conversionService.convert(b, BookDto.class))
                        .toList();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto dto) {
        Book book = bookService.addBook(conversionService.convert(dto, Book.class));
        return ResponseEntity.ok(conversionService.convert(book, BookDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable("id") Long id, @RequestBody BookDto dto) {
        Book book = bookService.addBook(conversionService.convert(dto, Book.class));
        bookService.updateBook(id, book);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
