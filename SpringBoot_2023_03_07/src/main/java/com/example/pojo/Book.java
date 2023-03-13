package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/8 15:51
 */
@Data
@Builder
@TableName("book")
public class Book {

    @TableId
    private Integer id;

    private String type;

    private String name;

    private String description;
}
