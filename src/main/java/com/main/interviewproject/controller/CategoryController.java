package com.main.interviewproject.controller;

import com.main.interviewproject.model.book.Book;
import com.main.interviewproject.model.book.BookCategory;
import com.main.interviewproject.model.category.Category;
import com.main.interviewproject.model.response.BaseResponse;
import com.main.interviewproject.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class CategoryController {
    Logger logger = LoggerFactory.getLogger(CategoryController.class.getName());

    @Autowired
    CategoryService categoryService;

    //------------------------------Start--------------Category----------------------//
    @DeleteMapping("/category/delete/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable long id) {
        BaseResponse response = categoryService.deleteCategory(id);
        if (response.getStatusCode() == HttpServletResponse.SC_OK) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/category/edit")
    ResponseEntity<?> editCategory(@RequestBody Category category) {
        BaseResponse response = categoryService.editCategory(category);
        if (response.getStatusCode() == HttpServletResponse.SC_OK) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/category/create")
    ResponseEntity<?> createCategory(@RequestBody Category category) {
        BaseResponse response = categoryService.addCategory(category);
        if (response.getStatusCode() == HttpServletResponse.SC_OK) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/categories/getAllCategories")
    ResponseEntity<?> getAllCategories() {
        BaseResponse response = categoryService.getAllCategories();
        if (response.getStatusCode() == HttpServletResponse.SC_OK) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //------------------------------End--------------Category----------------------//
}
