package ru.android_studio.pages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.android_studio.pages.entities.Category;
import ru.android_studio.pages.entities.Tag;
import ru.android_studio.pages.repository.CategoryRepository;
import ru.android_studio.pages.repository.TagRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    public Category save(Category page) {
        return categoryRepository.save(page);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Tag> findAllTags(Long id) {
        return tagRepository.findByPagesCategoryId(id);
    }
}