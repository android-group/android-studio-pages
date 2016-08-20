package ru.android_studio.pages.controllers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.android_studio.pages.entities.Category;
import ru.android_studio.pages.service.CategoryService;

import java.util.List;
import java.util.Set;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value="api/v1/categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @RequestMapping(value="api/v1/categoryTags")
    public Set<String> categories(Long id) {
        return categoryService.findAllTags(id);
    }
}
