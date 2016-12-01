package ru.android_studio.pages.config;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.android_studio.pages.elasticsearch.PageEntityListener;

@Component
public class HibernateListenersConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private PageEntityListener listener;

	@PostConstruct
	public void registerListeners() {
		HibernateEntityManagerFactory hibernateEntityManagerFactory = (HibernateEntityManagerFactory) this.entityManagerFactory;
		SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) hibernateEntityManagerFactory.getSessionFactory();
		EventListenerRegistry registry = sessionFactoryImpl.getServiceRegistry()
				.getService(EventListenerRegistry.class);
		registry.getEventListenerGroup(EventType.POST_COMMIT_INSERT).appendListener(listener);
		registry.getEventListenerGroup(EventType.POST_COMMIT_UPDATE).appendListener(listener);
		registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(listener);
	}

}