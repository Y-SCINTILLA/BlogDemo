package com.example.service;

import com.example.pojo.Comment;

import java.util.List;

public interface CommentService {
    void add(Comment comment);

    Comment selectByCommentId(Integer integer);

    List<Comment> selectAll();
}
