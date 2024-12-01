package ru.edu.springweb.repository;

import org.springframework.stereotype.Repository;
import ru.edu.springweb.entity.Book;
import ru.edu.springweb.exception.RepositoryException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private List<Book> books;
    private Long id;

    public BookRepository() {
        this.id = 3L;
        this.books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Бойцовский клуб");
        book1.setAuthor("Чак Паланик");
        books.add(book1);
        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Война и Мир");
        book2.setAuthor("Лев Николаевич Толстой");
        books.add(book2);
    }

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    public Book save(Book book) {
        book.setId(id);
        id++;
        books.add(book);
        return book;
    }

    public void delete(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    public Book update(Book book) {
        return books.stream()
                .filter(b -> b.getId().equals(book.getId()))
                .map(b -> {
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    return b;
                }).findFirst()
                .orElseThrow(() -> new RepositoryException("Ошибка при сохранении!"));
    }
}
