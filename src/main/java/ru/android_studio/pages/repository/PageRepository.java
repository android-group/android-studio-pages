package ru.android_studio.pages.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.android_studio.pages.entities.Page;
import ru.android_studio.pages.entities.PageInfo;

import java.util.HashSet;
import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {
    Page findById(long id);

    Page save(Page page);

    @EntityGraph(value = "Page.detail", type = EntityGraph.EntityGraphType.LOAD)
    List<PageInfo> findByCategoryId(Long id);

    @EntityGraph(value = "Page.detail", type = EntityGraph.EntityGraphType.LOAD)
    List<PageInfo> findByTagsNameIn(HashSet<String> names);

    @EntityGraph(value = "Page.detail", type = EntityGraph.EntityGraphType.LOAD)
    List<PageInfo> findByCategoryIdAndTagsNameIn(Long category, HashSet<String> strings);
}