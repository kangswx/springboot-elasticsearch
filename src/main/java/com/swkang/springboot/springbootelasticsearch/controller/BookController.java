package com.swkang.springboot.springbootelasticsearch.controller;

import com.swkang.springboot.springbootelasticsearch.domain.Book;
import com.swkang.springboot.springbootelasticsearch.service.BookService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("add")
    public Book add(Book book){
        bookService.save(book);
        System.out.println("ESinsert");
        return book;
    }

    @PutMapping("update")
    public Book update(Book book){
        bookService.save(book);
        System.out.println("ESupdate");
        return book;
    }

    @DeleteMapping("delete/{id}")
    public Book delete(@PathVariable Integer id){
        Optional<Book> op = bookService.findById(id);
        bookService.delete(op.get());
        return op.get();
    }

    @GetMapping("get/{id}")
    public Optional<Book> get(@PathVariable Integer id){
        return bookService.findById(id);
    }

    @GetMapping("search/{q}")
    public List<Book> searchAll(@PathVariable String q){

        System.out.println("q: "+q);
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(q);
        Iterable<Book> search = bookService.search(builder);
        Iterator<Book> iterator = search.iterator();
        List<Book> list = new ArrayList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }

    @GetMapping("/{page}/{size}/{q}")
    public Page<Book> searchAll(@PathVariable Integer page, @PathVariable Integer size, @PathVariable String q){
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchQuery("message", q));
        Page<Book> list = bookService.search(queryBuilder, PageRequest.of(page, size));
        System.out.println(list);
        System.out.println(list.getTotalElements());
        System.out.println(list.getContent());
        return list;
    }

}
