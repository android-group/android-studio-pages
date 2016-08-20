package ru.android_studio.pages.controllers.v1;

import com.fasterxml.jackson.annotation.JsonView;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.android_studio.pages.controllers.PageView;
import ru.android_studio.pages.entities.Page;
import ru.android_studio.pages.service.PageService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class PageController {
    @Autowired
    PageService pageService;

    @RequestMapping(value="v1/page")
    public Page page(@Nullable Long id) {
        Page page = pageService.findById(id);
        if (page != null) {
            return page;
        } else {
            throw new EntityNotFoundException("There is no page with given id");
        }
    }

    @RequestMapping(value="v1/pages")
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

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    static class EntityNotFoundException extends RuntimeException {
        EntityNotFoundException(String message) {
            super(message);
        }
    }
}
