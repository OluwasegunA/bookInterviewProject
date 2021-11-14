package com.main.interviewproject.model.category;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
/*import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;*/
import java.util.Date;

@Entity
@Table(name = "categories")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
    @SequenceGenerator(name = "categories_seq", sequenceName = "categories_seq", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(unique = true)
    private String name;

    @JsonProperty(value = "date_created")
    private Date date_created;

    @JsonProperty(value = "last_updated")
    private Date last_updated;

    public Category() {
        super();
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(long id, String name) {
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

    public Category( String name, Date date_created, Date last_updated) {
        this.name = name;
        this.date_created = date_created;
        this.last_updated = last_updated;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_created=" + date_created +
                ", last_updated=" + last_updated +
                '}';
    }
}
