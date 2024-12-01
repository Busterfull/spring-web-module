package ru.edu.springweb.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.edu.springweb.dto.BookDto;
import ru.edu.springweb.entity.Book;

@Component
public class BookToBookDto implements Converter<Book, BookDto> {

    @Override
    public BookDto convert(Book book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setAuthor(book.getAuthor());
        dto.setTitle(book.getTitle());
        return dto;
    }
}
