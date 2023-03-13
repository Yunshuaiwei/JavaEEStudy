package com.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/8 16:00
 */
@SpringBootTest
class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void getAll() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        List<Book> books = bookDao.selectList(null);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void getPage() {
        IPage<Book> page=new Page<>(1,5);
        List<Book> books = bookDao.selectPage(page, null).getRecords();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void testDelete() {

    }

    @Test
    void testUpdate() {
        Book book = Book.builder()
                .id(7)
                .type("数据库")
                .name("Redis 入门到精通")
                .description("Redis 教程")
                .build();
        System.out.println(bookDao.insert(book));
    }
}
