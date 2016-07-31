package ru.android_studio.pages.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
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
public class Page extends PageInfo implements Serializable {
    private Long id;

    private Author author;

    private String title;

    private String content;

    public Page() {

    }

    public Page(String title, Author author, Set<Tag> tags, Category category, String content) {
        super(title, author, tags, category);
        this.content = content;
    }

    @NotEmpty
//    @Lob
    @Basic(fetch = FetchType.LAZY)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
