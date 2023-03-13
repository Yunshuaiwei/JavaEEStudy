package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import com.example.pojo.Book;
import com.example.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/8 16:33
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public List<Book> getAll() {
        log.debug("service层 日志测试！！！");
        return bookDao.selectList(null);
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> selectPage(int currentPage, int size) {
        IPage<Book> page = new Page<>(currentPage, size);
        IPage<Book> selectPage = bookDao.selectPage(page, null);
        return selectPage.getRecords();
    }
}
