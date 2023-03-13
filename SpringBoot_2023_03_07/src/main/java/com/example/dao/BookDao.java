package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/8 15:54
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
