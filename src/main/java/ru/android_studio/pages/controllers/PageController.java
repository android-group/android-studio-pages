package ru.android_studio.pages.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.android_studio.pages.entities.Page;
import ru.android_studio.pages.service.PageService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class PageController {
    @Autowired
    PageService pageService;

    @RequestMapping(value="page")
    public Page page(@Nullable Long id) {
        Page page = pageService.findById(id);
        if (page != null) {
            return page;
        } else {
            throw new EntityNotFoundException("There is no page with given id");
        }
    }

    @RequestMapping(value="pages")
    @JsonView(PageView.InfoOnly.class)
    public List<Page> pages(@Nullable Long category, @Nullable String tags) {
        if (category == null && tags == null) {
            return pageService.findAll();
        } else if (category == null) {
            ArrayList<String> namesAsArray = commaSeparatedToList(tags);
            return pageService.findByTagNames(namesAsArray);
        } else if (tags == null) {
            return pageService.findByCategoryId(category);
        } else {
            ArrayList<String> namesAsArray = commaSeparatedToList(tags);
            return pageService.findByCategoryAndTagNames(category, namesAsArray);
        }
    }

    private static ArrayList<String> commaSeparatedToList(String tags) {
        String[] tagsAsArray = tags.split(",");
        ArrayList<String> list = new ArrayList<>(tagsAsArray.length);
        Collections.addAll(list, tags);
        return list;
    }

}
