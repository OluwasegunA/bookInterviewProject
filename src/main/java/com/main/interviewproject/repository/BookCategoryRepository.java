package com.main.interviewproject.repository;

import com.main.interviewproject.model.book.Book;
import com.main.interviewproject.model.book.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

}
