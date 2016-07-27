package ru.android_studio.pages.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by TarCV on 17.07.2016.
 */
@Entity
@Table(name = "authors")
public class Author implements Serializable {
    private Long id;

    private String nickname;

    private Author() {
    }

    public Author(String nickname) {
        this.nickname = nickname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(min = 4, max = 20)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
