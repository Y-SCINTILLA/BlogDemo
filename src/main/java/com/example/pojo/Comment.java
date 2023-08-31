package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Comment {
    private Integer commentId;
    private Integer articleId;
    private Integer uid;
    private String commentTime;
    private Integer likes;
    private String content;

}
