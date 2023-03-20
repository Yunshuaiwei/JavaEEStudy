package com.example.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/8 15:51
 */
@Data
@Builder
public class Book {

    private Integer id;

    private String type;

    private String name;

    private String description;
}
