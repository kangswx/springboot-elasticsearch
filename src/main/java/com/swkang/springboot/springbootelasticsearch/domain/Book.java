package com.swkang.springboot.springbootelasticsearch.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "db_index", type = "book")
public class Book {

    @Id
    private Integer id;
    private String name;
    private String message;
    private String type;
}
