package com.example.springboot_2023_03_17;

import com.example.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SpringBootApplicationTests {

    @Test
    void contextLoads(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "SELECT * FROM book";
        RowMapper<Book> mapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Book.builder().id(rs.getInt("id"))
                        .type(rs.getString("type"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .build();
            }
        };
        List<Book> list = jdbcTemplate.query(sql, mapper);
        for (Book book : list) {
            System.out.println(book);
        }
    }

    @Test
    void testSetRedis(@Autowired RedisTemplate<String,String> redisTemplate) {
        ValueOperations<String, String> forValue = redisTemplate.opsForValue();
        forValue.set("key1", "value1");

    }

    @Test
    void testGetRedis(@Autowired RedisTemplate<String, String> redisTemplate) {
        ValueOperations<String, String> forValue = redisTemplate.opsForValue();
        Object value = forValue.get("Key2");
        System.out.println(value);

    }

}
