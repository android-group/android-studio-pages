package ru.android_studio.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.android_studio.pages.entities.Author;
import ru.android_studio.pages.entities.Page;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findById(long id);
    Author findByNickname(String nickname);

    Author save(Author page);
}