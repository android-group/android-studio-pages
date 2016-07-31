package ru.android_studio.pages.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import ru.android_studio.pages.entities.Page;
import ru.android_studio.pages.entities.PageInfo;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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