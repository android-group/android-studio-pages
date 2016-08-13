package ru.android_studio.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.android_studio.pages.entities.Tag;

import java.util.Set;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String name);

    Tag save(Tag page);

    Set<Tag> findByPagesCategoryId(Long id);    //'Set' is used to avoid duplicates
}