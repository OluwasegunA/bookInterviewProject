package com.main.interviewproject.model.book;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_seq")
    @SequenceGenerator(name = "books_seq", sequenceName = "books_seq", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String author;

    //private long category_id;

    @JsonProperty(value = "date_created")
    private Date date_created;

    @JsonProperty(value = "last_updated")
    private Date last_updated;

    public Book() {
        super();
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public long getCategoryId() {
        return category_id;
    }

    public void setCategoryId(long category_id) {
        this.category_id = category_id;
    }*/

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public Book( String name, String author, /*long category_id,*/ Date date_created, Date last_updated) {
        this.name = name;
        this.author = author;
        //this.category_id = category_id;
        this.date_created = date_created;
        this.last_updated = last_updated;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                //", category_id=" + category_id +
                ", date_created=" + date_created +
                ", last_updated=" + last_updated +
                '}';
    }
}
