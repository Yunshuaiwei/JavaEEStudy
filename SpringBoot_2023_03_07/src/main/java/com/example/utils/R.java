package com.example.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/9 11:54
 */
@Data
@NoArgsConstructor
public class R{
    private Boolean success;

    private Object data;

    public R(Boolean success) {
        this.success = success;
    }

    public R(Boolean success,Object data) {
        this.success = success;
        this.data=data;
    }
}
