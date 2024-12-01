package ru.edu.springweb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Book {
    private Long id;
    private String title;
    private String author;
}
