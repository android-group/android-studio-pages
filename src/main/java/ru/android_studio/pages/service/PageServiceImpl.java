package ru.android_studio.pages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.android_studio.pages.entities.Page;
import ru.android_studio.pages.repository.PageRepository;

import javax.transaction.Transactional;

@Service("pageService")
public class PageServiceImpl implements PageService {

    @Autowired
    private PageRepository pageRepository;

    @Transactional
    public Page save(Page page) {
        return pageRepository.save(page);
    }

    public Page findById(Long id) {
        return pageRepository.findById(id);
    }
}