package ru.android_studio.pages.entities;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.elasticsearch.annotations.Document;

import ru.android_studio.pages.controllers.PageView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by TarCV on 17.07.2016.
 */
@Entity
@Table(name = "pages")
@NamedEntityGraph(name = "Page.detail",
        attributeNodes = {
                @NamedAttributeNode("author"),
                @NamedAttributeNode("category"),
                @NamedAttributeNode("tags")
        }
)
public class Page implements Serializable {
    private Long id;

    private String content;

    private Author author;

    private String title;

    private Set<Tag> tags;

    private Category category;

    public Page() {

    }

    public Page(String title, Author author, Set<Tag> tags, Category category, String content) {
        this.author = author;
        this.title = title;
        this.tags = tags;
        this.category = category;
        this.content = content;
    }

    @NotEmpty
    @Lob
    @Basic(fetch = FetchType.LAZY)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(PageView.InfoOnly.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty
    @Size(min=4, max=30)
    @JsonView(PageView.InfoOnly.class)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @NotNull
    @JsonView(PageView.InfoOnly.class)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @NotEmpty
    @ManyToMany
    @JsonView(PageView.InfoOnly.class)
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @NotNull
    @ManyToOne
    @JsonView(PageView.InfoOnly.class)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
