package ru.android_studio.pages.service;

import ru.android_studio.pages.entities.Page;

import java.util.ArrayList;
import java.util.List;

public interface PageService {
    Page findById(Long id);

    List<Page> findByCategoryId(Long id);

    List<Page> findByTagNames(ArrayList<String> names1);

    List<Page> findByCategoryAndTagNames(long category, ArrayList<String> tagNames);

    List<Page> findAll();
}