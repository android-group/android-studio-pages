package ru.android_studio.pages.controllers;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.android_studio.pages.entities.Page;
import ru.android_studio.pages.service.PageService;

import java.util.Arrays;
import java.util.List;

@RestController
public class PageController {
    @Autowired
    PageService pageService;

    @RequestMapping(value="page", method = RequestMethod.GET, produces="application/json")
    public Page page(@Nullable Long id) {
        Page page = pageService.findById(id);
        if (page != null) {
            return page;
        } else {
            throw new EntityNotFoundException("There is no page with given id");
        }
    }

    @RequestMapping(value="pages", method = RequestMethod.GET, produces="application/json")
    public List<Page> pages(@Nullable Long category, @Nullable String tags) {
        String[] namesAsArray = (tags == null) ? null : tags.split(",");
        if (category == null && tags == null) {
            return pageService.findAll();
        } else if (category == null) {
                return pageService.findByTagNames(Arrays.asList(namesAsArray));
        } else if (namesAsArray == null) {
            return pageService.findByCategoryId(category);
        } else {
            return pageService.findByCategoryAndTagNames(category, Arrays.asList(namesAsArray));
        }
    }

}
