package com.example.service;

import com.example.pojo.Book;

import java.util.List;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/8 16:31
 */
public interface BookService {

    Boolean save(Book book);

    List<Book> getAll();

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> selectPage(int currentPage,int size);
}
