package com.book.book.Controller;

import com.book.book.Repo.BookRepo;
import com.book.book.dto.Authors;
import com.book.book.dto.BookDto;
import com.book.book.feignclient.Author;
import com.book.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private BookRepo bookRepository;

    @Autowired
    private Author authorClient;



    @GetMapping("/books")
    public List<BookDto> getAllBooks(){
       List<Book> bookList=bookRepository.findAll();
       List<BookDto> bookDtoList=bookList.stream().map(book -> {Authors authors=authorClient.getAuthor(book.getAuthorId());
       return BookDto.fromBook(book,authors);}).toList();
       return bookDtoList;
    }


    @GetMapping("/books/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        Book book=bookRepository.findById(id);
        Authors authors=authorClient.getAuthor(book.getId());
        return BookDto.fromBook(book,authors);
    }
}
