package com.example.service.impl;

import com.example.mapper.CommentMapper;
import com.example.pojo.Comment;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceimpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void add(Comment comment) {
        commentMapper.add(comment);
    }

    @Override
    public Comment selectByCommentId(Integer commentId) {
        return commentMapper.selectByCommentId(commentId);
    }

    @Override
    public List<Comment> selectAll() {
        return commentMapper.selectAll();
    }
}
