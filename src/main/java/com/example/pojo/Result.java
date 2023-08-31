package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private Integer code;
    private String message;//服务器是否错误的提示
    private Object data;//所有类型Object

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
