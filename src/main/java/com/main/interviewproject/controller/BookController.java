package com.main.interviewproject.controller;

import com.main.interviewproject.model.book.Book;
import com.main.interviewproject.model.book.BookCategory;
import com.main.interviewproject.model.response.BaseResponse;
import com.main.interviewproject.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class.getName());

    @Autowired
    BookService bookService;

    //------------------------------Start--------------Book----------------------//
    @DeleteMapping("/books/delete/{id}")
    ResponseEntity<?> deleteBook(@PathVariable long id) {
        BaseResponse response = bookService.deleteBook(id);
        if (response.getStatusCode() == HttpServletResponse.SC_OK) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/books/edit")
    ResponseEntity<?> editBook(@RequestBody Book book) {
        BaseResponse response = bookService.editBook(book);
        if (response.getStatusCode() == HttpServletResponse.SC_OK) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/books/create")
    ResponseEntity<?> createBook(@RequestBody Book book) {
        BaseResponse response = bookService.createBook(book);
        if (response.getStatusCode() == HttpServletResponse.SC_OK) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/books/getAllBooks")
    ResponseEntity<?> getAllBooks() {
        BaseResponse response = bookService.getAllBooks();
        if (response.getStatusCode() == HttpServletResponse.SC_OK) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/books/addToCategory")
    ResponseEntity<?> addBookToCategory(@RequestBody BookCategory bookCat) {
        BaseResponse response = bookService.addBookToCategory(bookCat);
        if (response.getStatusCode() == HttpServletResponse.SC_OK) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    //------------------------------End--------------Book----------------------//

}
