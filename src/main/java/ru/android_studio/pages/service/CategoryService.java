package ru.android_studio.pages.service;

import ru.android_studio.pages.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    List<Category> findAll();

    Set<String> findAllTags(Long id);
}