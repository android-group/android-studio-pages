package ru.android_studio.pages.service;

import ru.android_studio.pages.entities.Category;
import ru.android_studio.pages.entities.Tag;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    List<Tag> findAllTags(Long id);
}