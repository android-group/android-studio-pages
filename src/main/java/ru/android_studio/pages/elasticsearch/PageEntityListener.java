package ru.android_studio.pages.elasticsearch;

import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.android_studio.pages.entities.Page;

// TODO: verify that this implementation correctly handles failures of ES side

@Component
public class PageEntityListener implements PostInsertEventListener, PostUpdateEventListener, PostDeleteEventListener {
	private static final Logger log = LoggerFactory.getLogger(PageEntityListener.class);

	@Autowired
	private ElasticPageRepository elasticRepository;

	@Override
	public void onPostInsert(PostInsertEvent event) {
		Object entity = event.getEntity();
		if (entity instanceof Page) {
			elasticRepository.save(new ElasticPage((Page) entity));
		}
	}

	@Override
	public boolean requiresPostCommitHanding(EntityPersister persister) {
		// TODO verify correct return value here
		return true;
	}

	@Override
	public void onPostDelete(PostDeleteEvent event) {
		Object entity = event.getEntity();
		if (entity instanceof Page) {
			elasticRepository.delete(((Page)entity).getId());
		}
	}

	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		// TODO verify if this implementation is correct
		Object entity = event.getEntity();
		if (entity instanceof Page) {
			elasticRepository.save(new ElasticPage((Page) entity));
		}
	}

}
