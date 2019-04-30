package com.swkang.springboot.springbootelasticsearch.service;

import com.swkang.springboot.springbootelasticsearch.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookService extends ElasticsearchRepository<Book, Integer> {

}
