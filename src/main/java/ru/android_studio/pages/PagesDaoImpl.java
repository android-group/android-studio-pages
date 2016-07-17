package ru.android_studio.pages;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by TarCV on 17.07.2016.
 */
@Repository
public class PagesDaoImpl implements PagesDao {
    @Resource
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Page findPageById(int id) {
        return (Page)this.sessionFactory.getCurrentSession()
                .createQuery("from pages where id=?")
                .setParameter(0, String.valueOf(id))
                .getSingleResult();
    }
}
