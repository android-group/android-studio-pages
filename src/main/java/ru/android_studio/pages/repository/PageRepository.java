package ru.android_studio.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.android_studio.pages.entities.Page;

public interface PageRepository extends JpaRepository<Page, Long> {
    Page findById(long id);

    Page save(Page page);
}