package ru.android_studio.pages.service;

import ru.android_studio.pages.entities.Page;

public interface PageService {
    Page findById(Long id);
}