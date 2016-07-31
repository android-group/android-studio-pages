package ru.android_studio.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.android_studio.pages.entities.Tag;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findById(long id);

    Tag findByName(String name);

    Tag save(Tag page);

    List<Tag> findByPagesCategoryId(Long id);
}