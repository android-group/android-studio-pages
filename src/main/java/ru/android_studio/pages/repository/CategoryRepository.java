package ru.android_studio.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.android_studio.pages.entities.Category;
import ru.android_studio.pages.entities.Page;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(long id);
    Category findByName(String name);

    Category save(Category page);
}