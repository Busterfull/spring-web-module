package ru.edu.springweb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.springweb.entity.Book;
import ru.edu.springweb.exception.LibraryException;
import ru.edu.springweb.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new LibraryException("Данной книги не существует"));
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void updateBook(Long id, Book modifed) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new LibraryException("Данной книги не существует"));
        book.setAuthor(modifed.getAuthor());
        book.setTitle(modifed.getTitle());
        bookRepository.update(book);
    }

    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }
}
