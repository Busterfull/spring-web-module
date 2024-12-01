package ru.edu.springweb.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.edu.springweb.dto.BookDto;
import ru.edu.springweb.entity.Book;

@Component
public class BookDtoToBook implements Converter<BookDto, Book> {

    @Override
    public Book convert(BookDto dto) {
        Book book = new Book();
        book.setAuthor(dto.getAuthor());
        book.setTitle(dto.getTitle());
        return book;
    }
}
