package ru.android_studio.pages.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by TarCV on 17.07.2016.
 */
@Entity
@Table(name="pages")
public class Page implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Author author;

    @NotEmpty
    @Size(min=4, max=30)
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    @ManyToMany
    private Set<Tag> tags;

    @NotNull
    @ManyToOne
    private Category category;

    private Page() {
    }

    public Page(String title, Author author, String content, Set<Tag> tags, Category category) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.tags = tags;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
