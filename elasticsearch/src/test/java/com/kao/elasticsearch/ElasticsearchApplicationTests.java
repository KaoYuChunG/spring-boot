package com.kao.elasticsearch;

import com.kao.elasticsearch.bean.Article;
import com.kao.elasticsearch.bean.Book;
import com.kao.elasticsearch.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ElasticsearchApplicationTests {

	@Autowired
	JestClient jestClient;

	@Autowired
	BookRepository bookRepository;

	@Test
	public void teste() {
		Book book = new Book();
		book.setId(1);
		book.setAuthor("Gustavo");

		bookRepository.index(book);
		bookRepository.findByBookName("Gsuatvo");

	}

	@Test
	void add() {
		Article article = new Article();
		article.setId(1);
		article.setAuthor("kao");
		article.setContent("great news");

		//create one index
		Index index = new Index.Builder(article).index("chun").type("news").build();
		try {
			jestClient.execute(index);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void search() {
		String json = "\n"+
				"   \"query\" : {\n" +
				"       \"match\" : {\n" +
				"           \"content\" : \"hell\"\n" +
				"       }\n" +
				"   }\n" +
				"}";
//		create one search
		Search search = new Search.Builder(json).addIndex("chun").addType("news").build();
		try {
			SearchResult searchResult = jestClient.execute(search);
			System.out.println(searchResult.getJsonString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
