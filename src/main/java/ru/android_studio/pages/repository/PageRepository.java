package ru.android_studio.pages.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.android_studio.pages.entities.Page;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {
    Page save(Page page);

    @EntityGraph(value = "Page.detail", type = EntityGraph.EntityGraphType.LOAD)
    Page findById(long id);

    @EntityGraph(value = "Page.detail", type = EntityGraph.EntityGraphType.LOAD)
    List<Page> findAll();

    @EntityGraph(value = "Page.detail", type = EntityGraph.EntityGraphType.LOAD)
    List<Page> findByCategoryId(Long id);

    @EntityGraph(value = "Page.detail", type = EntityGraph.EntityGraphType.LOAD)
    List<Page> findByTagsNameIn(List<String> names);

    @EntityGraph(value = "Page.detail", type = EntityGraph.EntityGraphType.LOAD)
    List<Page> findByCategoryIdAndTagsNameIn(Long category, List<String> strings);
}