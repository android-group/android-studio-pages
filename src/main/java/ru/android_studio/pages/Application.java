package ru.android_studio.pages;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.android_studio.pages.entities.Author;
import ru.android_studio.pages.entities.Category;
import ru.android_studio.pages.entities.Page;
import ru.android_studio.pages.entities.Tag;
import ru.android_studio.pages.repository.AuthorRepository;
import ru.android_studio.pages.repository.CategoryRepository;
import ru.android_studio.pages.repository.PageRepository;
import ru.android_studio.pages.repository.TagRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(
	        PageRepository pageRepository,
            AuthorRepository authorRepository,
            CategoryRepository categoryRepository,
            TagRepository tagRepository
    ) {
        return args -> {
            String[] stringNumbers = {"0", "1", "2"};

            Tag[] tags = Stream.of(stringNumbers)
                    .map(number -> tagRepository.save(new Tag("Tag" + number)))
                    .toArray(Tag[]::new);

            Author[] authors = Stream.of(stringNumbers)
                    .map(number -> authorRepository.save(new Author("Author" + number)))
                    .toArray(Author[]::new);

            Category[] categories = Stream.of(stringNumbers)
                    .map(number -> categoryRepository.save(new Category("Category" + number)))
                    .toArray(Category[]::new);

            Stream.of(new Page[] {
                new Page("Author0 Tag0,Tag1 Cat0", authors[0], createSet(tags[0], tags[1]), categories[0], "Content"),
                new Page("Author0 Tag0 Cat0", authors[0], createSet(tags[0]), categories[0], "Content"),
                new Page("Author0 Tag1 Cat1", authors[0], createSet(tags[1]), categories[1], "Content"),
            }).forEach(pageRepository::save);
        };
	}

    private static <T> Set<T> createSet(T... tags) {
        return new HashSet<>(Arrays.asList(tags));
    }
}
