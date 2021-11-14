package com.main.interviewproject.model.book;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookcategories")

public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_categories_seq")
    @SequenceGenerator(name = "books_categories_seq", sequenceName = "books_categories_seq", initialValue = 1, allocationSize = 1)
    private long id;

    private long book_id;

    private long category_id;

    @JsonProperty(value = "date_created")
    private Date date_created;

    @JsonProperty(value = "last_updated")
    private Date last_updated;

    public BookCategory() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return book_id;
    }

    public void setBookId(long book_id) {
        this.book_id = book_id;
    }

    public long getCategoryId() {
        return category_id;
    }

    public void setCategoryId(long category_id) {
        this.category_id = category_id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }

    public BookCategory( long book_id, long category_id, Date date_created, Date last_updated) {
        this.book_id = book_id;
        this.category_id = category_id;
        this.date_created = date_created;
        this.last_updated = last_updated;
    }

    @Override
    public String toString() {
        return "BookCategory{" +
                "id=" + id +
                ", book_id='" + book_id + '\'' +
                ", category_id=" + category_id +
                ", date_created=" + date_created +
                ", last_updated=" + last_updated +
                '}';
    }
}
