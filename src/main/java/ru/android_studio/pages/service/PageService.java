package ru.android_studio.pages.service;

import ru.android_studio.pages.entities.Page;

import java.util.List;

public interface PageService {
    Page findById(Long id);

    List<Page> findByCategoryId(Long id);

    List<Page> findByTagNames(List<String> names1);

    List<Page> findByCategoryAndTagNames(long category, List<String> tagNames);

    List<Page> findAll();
}