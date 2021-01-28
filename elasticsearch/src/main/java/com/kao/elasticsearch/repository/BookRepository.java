package com.kao.elasticsearch.repository;

import com.kao.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    public List<Book> findByBookName(String bookName);
}
