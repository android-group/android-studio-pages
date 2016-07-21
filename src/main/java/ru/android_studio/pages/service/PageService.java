package ru.android_studio.pages.service;

import ru.android_studio.pages.entities.Page;

import java.util.List;

public interface PageService {
    List<Page> findById(int id);
}