package com.kao.elasticsearchhighlevel;


import com.kao.elasticsearchhighlevel.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ElasticsearchHighLevelApplicationTests {

	@Autowired
	private PersonService personService;

	@Test
	public void deleteIndexTest() {
		personService.deleteIndex(ElasticsearchConstant.INDEX_NAME);
	}

	@Test
	public void createIndexTest() {
		personService.createIndex(ElasticsearchConstant.INDEX_NAME);
	}

	@Test
	public void insertTest() {
		List<Person> list = new ArrayList<>();
		list.add(Person.builder().age(11).birthday(new Date()).country("CN").id(1L).name("kkk").remark("test1").build());
		list.add(Person.builder().age(22).birthday(new Date()).country("US").id(2L).name("hiahia").remark("test2").build());
		list.add(Person.builder().age(33).birthday(new Date()).country("ID").id(3L).name("rsrs").remark("test3").build());

		personService.insert(ElasticsearchConstant.INDEX_NAME, list);
	}

	@Test
	public void updateTest() {
		Person person = Person.builder().age(33).birthday(new Date()).country("ID_update").id(3L).name("rsrsupdate").remark("test3_update").build();
		List<Person> list = new ArrayList<>();
		list.add(person);
		personService.update(ElasticsearchConstant.INDEX_NAME, list);
	}

	@Test
	public void deleteTest() {
		personService.delete(ElasticsearchConstant.INDEX_NAME, Person.builder().id(1L).build());
	}

	@Test
	public void searchListTest() {
		List<Person> personList = personService.searchList(ElasticsearchConstant.INDEX_NAME);
		System.out.println(personList);
	}

}
