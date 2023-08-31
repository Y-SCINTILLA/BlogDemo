package com.example.mapper;

import com.example.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void add(Comment comment);

    Comment selectByCommentId(Integer commentId);

    List<Comment> selectAll();
}
