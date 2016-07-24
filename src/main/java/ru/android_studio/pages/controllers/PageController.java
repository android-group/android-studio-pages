package ru.android_studio.pages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.android_studio.pages.entities.Page;
import ru.android_studio.pages.service.PageService;

@RestController
public class PageController {
    @Autowired
    PageService pageService;

    @RequestMapping(value="page/{id}", method = RequestMethod.GET, produces="application/json")
    public Page pageById(@PathVariable Long id) {
        Page page = pageService.findById(id);
        if (page != null) {
            return page;
        } else {
            throw new EntityNotFoundException("There is no page with given id");
        }
    }
}
