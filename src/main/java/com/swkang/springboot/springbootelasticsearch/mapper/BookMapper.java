package com.swkang.springboot.springbootelasticsearch.mapper;

import com.swkang.springboot.springbootelasticsearch.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

    void add(Book book);

    Book findById(Integer id);

    void delete(Integer id);
}
