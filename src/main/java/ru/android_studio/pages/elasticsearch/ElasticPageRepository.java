package ru.android_studio.pages.elasticsearch;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import ru.android_studio.pages.entities.Page;

public interface ElasticPageRepository extends ElasticsearchRepository<ElasticPage, Long> {
	List<Page> findByContentLike(String content);
}
