package ru.android_studio.pages.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by TarasovKonstantin on 30.07.2016.
 */
@MappedSuperclass
public class PageInfo implements Serializable {
    private Author author;

    private String title;

    private Set<Tag> tags;

    private Long id;

    private Category category;

    public PageInfo() {
    }

    public PageInfo(String title, Author author, Set<Tag> tags, Category category) {
        this.author = author;
        this.title = title;
        this.tags = tags;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty
    @Size(min=4, max=30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @NotNull
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @NotEmpty
    @ManyToMany
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @NotNull
    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
