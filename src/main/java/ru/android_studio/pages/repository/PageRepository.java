package ru.android_studio.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.android_studio.pages.entities.Page;

import java.util.List;

@Repository("pageRepository")
public interface PageRepository extends JpaRepository<Page, Long> {
    List<Page> findById(long id);
}