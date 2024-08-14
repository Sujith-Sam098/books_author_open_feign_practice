package com.book.book.Repo;

import com.book.book.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepo {
    private final List<Book> books = new ArrayList<>();

    public BookRepo() {
        books.add(new Book(1L, "1984", 1L));
        books.add(new Book(2L, "Harry Potter", 2L));
        books.add(new Book(3L, "To Kill a Mockingbird", 3L));
        books.add(new Book(4L, "The Lord of the Rings", 4L));
        books.add(new Book(5L, "Pride and Prejudice", 5L));
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(Long id) {
        return books.stream().filter(book -> Objects.equals(book.getId(), id)).findFirst().orElseThrow(null);
    }
}
