package ru.android_studio.pages.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min=4, max=20)
    private String name;

    private Category() {
    }
    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
