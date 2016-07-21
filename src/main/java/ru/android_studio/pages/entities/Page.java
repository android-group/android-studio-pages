package ru.android_studio.pages.entities;

//import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by TarCV on 17.07.2016.
 */
@Entity
@Table(name="page")
public class Page implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@NotEmpty private Author author;

//    @NotEmpty
    @Size(min=4, max=20)
    private String title;

//    @NotEmpty
    private String content;
//    private Set<Tag> tags;


    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
