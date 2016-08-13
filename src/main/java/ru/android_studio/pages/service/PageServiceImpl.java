package ru.android_studio.pages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.android_studio.pages.entities.Page;
import ru.android_studio.pages.repository.PageRepository;

import javax.transaction.Transactional;
import java.util.*;

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

    @Override
    public List<Page> findByCategoryId(Long id) {
        return pageRepository.findByCategoryId(id);
    }

    @Override
    public List<Page> findByTagNames(ArrayList<String> names) {
        return pageRepository.findByTagsNameIn(names);
    }

    @Override
    public List<Page> findByCategoryAndTagNames(long category, ArrayList<String> tagNames) {
        return pageRepository.findByCategoryIdAndTagsNameIn(category, tagNames);
    }

    @Override
    public List<Page> findAll() {
        return pageRepository.findAll();
    }
}