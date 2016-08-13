package ru.android_studio.pages.service;

import org.jetbrains.annotations.Nullable;
import ru.android_studio.pages.entities.Page;
import ru.android_studio.pages.entities.PageInfo;

import java.util.List;

public interface PageService {
    Page findById(Long id);

    List<PageInfo> findByCategoryId(Long id);

    List<PageInfo> findByTagNames(@Nullable String[] tag);

    List<PageInfo> findByCategoryAndTagNames(long category, String[] namesAsArray);
}