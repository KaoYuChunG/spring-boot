package com.kao.elasticsearchhighlevel.service;

import org.springframework.lang.Nullable;

import java.util.List;

public interface PersonService {

    void createIndex(String index);
    
    void deleteIndex(String index);
    
    void insert(String index, List<Person> list);
    
    void update(String index, List<Person> list);
    
    void delete(String index, @Nullable Person person);
    
    List<Person> searchList(String index);
}
