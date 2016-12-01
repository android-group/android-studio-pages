package ru.android_studio.pages.elasticsearch;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

import ru.android_studio.pages.entities.Page;

@Entity
@Document(indexName = "page")
public class ElasticPage implements Serializable {
	private Long id;
	
    private String content;

    private String title;

    public ElasticPage(Page jpaPage) {
    	this.id = jpaPage.getId();
    	this.title = jpaPage.getTitle();
    	this.content = jpaPage.getContent();
    }

    public ElasticPage(Long id, String title, String content) {
    	this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
