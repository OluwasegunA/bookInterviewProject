package com.main.interviewproject.service;

import com.main.interviewproject.model.book.Book;
import com.main.interviewproject.model.book.BookCategory;
import com.main.interviewproject.model.response.BaseResponse;
import com.main.interviewproject.repository.BookCategoryRepository;
import com.main.interviewproject.repository.BookRepository;
import com.main.interviewproject.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Service
public class BookService {
    Logger logger = LoggerFactory.getLogger(BookService.class.getName());

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    public BaseResponse createBook(Book model) {
        BaseResponse response = new BaseResponse();
        try {
            model.setDate_created(new Date());
            model.setLast_updated(new Date());
            Book savedBook = bookRepository.save(model);
            response.setData(savedBook);
            response.setDescription("Book created successfully");
            response.setStatusCode(HttpServletResponse.SC_OK);
            logger.info(response.getDescription() + ": {}", savedBook.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            response.setDescription("Book not created");
            response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            logger.error(response.getDescription());
        }
        return response;
    }


    public BaseResponse deleteBook(long bookId) {
        BaseResponse response = new BaseResponse();
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            response.setDescription("Book deleted successfully");
            response.setStatusCode(HttpServletResponse.SC_OK);
            logger.info(response.getDescription());
        } else {
            response.setDescription("Book not found");
            response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            logger.error(response.getDescription());
        }
        return response;
    }


    public BaseResponse editBook(Book book) {
        BaseResponse response = new BaseResponse();
        if (bookRepository.existsById(book.getId())) {
            book.setLast_updated(new Date());
            Book updatedBook = bookRepository.save(book);
            response.setData(updatedBook);
            response.setDescription("Book updated successfully.");
            response.setStatusCode(HttpServletResponse.SC_OK);
            logger.info(response.getDescription() + ": {}", updatedBook.toString());
        } else {
            response.setDescription("Book not found.");
            response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            logger.error(response.getDescription());
        }

        return response;
    }

    public BaseResponse getAllBooks() {
        BaseResponse response = new BaseResponse();
        List<Book> books = bookRepository.findAll();
        if (!books.isEmpty()) {
            response.setData(books);
            response.setDescription("Books found successfully.");
            response.setStatusCode(HttpServletResponse.SC_OK);
            logger.info(response.getDescription());
        } else {
            response.setDescription("No Book found.");
            response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            logger.error(response.getDescription());
        }
        return response;
    }

    public BaseResponse addBookToCategory(BookCategory bookCat){
        BaseResponse response = new BaseResponse();
        try {
            if (!bookRepository.existsById(bookCat.getBookId()))
            {
                response.setDescription("Book with the specified Id does not exist");
                response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            }
            else if(!categoryRepository.existsById(bookCat.getCategoryId())){
                response.setDescription("Category with the specified Id does not exist");
                response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            }
            else{
                bookCat.setDate_created(new Date());
                bookCat.setLast_updated(new Date());
                BookCategory savedBookCategory = bookCategoryRepository.save(bookCat);
                response.setData(savedBookCategory);
                response.setDescription("Book added to category successfully");
                response.setStatusCode(HttpServletResponse.SC_OK);
                logger.info(response.getDescription() + ": {}", savedBookCategory.toString());
            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            response.setDescription("Book not added to category");
            response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            logger.error(response.getDescription());
        }
        return response;
    }

}
