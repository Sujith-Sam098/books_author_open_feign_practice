package com.book.book.dto;

import com.book.book.model.Book;

import java.util.List;

public record BookDto(Long id,
                      String name,
                      Authors authors) {
    public BookDto(Long id, String name, Authors authors) {
        this.id = id;
        this.name = name;
        this.authors = authors;
    }

   public static BookDto fromBook(Book book,Authors authors)
   {
       return new BookDto(book.getId(), book.getTitle(),authors);
   }

}
