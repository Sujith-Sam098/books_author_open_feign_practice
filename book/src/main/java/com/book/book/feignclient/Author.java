package com.book.book.feignclient;

import com.book.book.dto.Authors;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Author",url = "http://localhost:8080/authors")
public interface Author {
    @GetMapping("/{id}")
    public Authors getAuthor(@PathVariable long id);
}
