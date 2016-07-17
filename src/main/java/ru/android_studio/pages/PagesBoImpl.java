package ru.android_studio.pages;

/**
 * Created by TarCV on 17.07.2016.
 */
public class PagesBoImpl implements PagesBo {
    PagesDao pagesDao;

    public void setPagesDao(PagesDao pagesDao) {
        this.pagesDao = pagesDao;
    }

    @Override
    public Page findPageById(int id) {
        return pagesDao.findPageById(id);
    }
}
