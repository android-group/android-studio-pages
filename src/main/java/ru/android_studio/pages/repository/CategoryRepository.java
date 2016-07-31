package ru.android_studio.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.android_studio.pages.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(long id);


    Category save(Category page);
}