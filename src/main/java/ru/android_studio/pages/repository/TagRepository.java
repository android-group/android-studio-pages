package ru.android_studio.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.android_studio.pages.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findById(long id);

    Tag findByName(String name);

    Tag save(Tag page);
}