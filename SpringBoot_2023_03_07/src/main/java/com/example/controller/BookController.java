package com.example.controller;

import com.example.pojo.Book;
import com.example.service.BookService;
import com.example.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/9 11:26
 */
@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public R getAll() {
        log.info("Controller层 日志测试！！！");
        return new R(true, bookService.getAll());
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.update(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    @Cacheable(value = "cacheSpace",key = "#id")
    public R getBookById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    @GetMapping("{currentPage}/{size}")
    public R getBookPage(@PathVariable Integer currentPage, @PathVariable Integer size) {
        return new R(true, bookService.selectPage(currentPage, size));
    }
}
