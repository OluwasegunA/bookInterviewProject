package com.main.interviewproject.service;

import com.main.interviewproject.model.book.Book;
import com.main.interviewproject.model.category.Category;
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
public class CategoryService {
    Logger logger = LoggerFactory.getLogger(BookService.class.getName());

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    public BaseResponse addCategory(Category model) {
        BaseResponse response = new BaseResponse();
        try {
            model.setDate_created(new Date());
            model.setLast_updated(new Date());
            Category savedCategory = categoryRepository.save(model);
            response.setData(savedCategory);
            response.setDescription("Category created successfully");
            response.setStatusCode(HttpServletResponse.SC_OK);
            logger.info(response.getDescription() + ": {}", savedCategory.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            response.setDescription("Category not created");
            response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            logger.error(response.getDescription());
        }
        return response;
    }


    public BaseResponse deleteCategory(long categoryId) {
        BaseResponse response = new BaseResponse();
        if (categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
            response.setDescription("Category deleted successfully");
            response.setStatusCode(HttpServletResponse.SC_OK);
            logger.info(response.getDescription());
        } else {
            response.setDescription("Category not found");
            response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            logger.error(response.getDescription());
        }
        return response;
    }


    public BaseResponse editCategory(Category category) {
        BaseResponse response = new BaseResponse();
        if (categoryRepository.existsById(category.getId())) {
            category.setLast_updated(new Date());
            Category updatedCategory = categoryRepository.save(category);
            response.setData(updatedCategory);
            response.setDescription("Category updated successfully.");
            response.setStatusCode(HttpServletResponse.SC_OK);
            logger.info(response.getDescription() + ": {}", updatedCategory.toString());
        } else {
            response.setDescription("Category not found.");
            response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            logger.error(response.getDescription());
        }

        return response;
    }

    public BaseResponse getAllCategories() {
        BaseResponse response = new BaseResponse();
        List<Category> categories = categoryRepository.findAll();
        if (!categories.isEmpty()) {
            response.setData(categories);
            response.setDescription("Categories found successfully.");
            response.setStatusCode(HttpServletResponse.SC_OK);
            logger.info(response.getDescription());
        } else {
            response.setDescription("No Category found.");
            response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            logger.error(response.getDescription());
        }
        return response;
    }
}
