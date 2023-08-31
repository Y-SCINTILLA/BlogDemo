package com.example.controller;

import com.example.pojo.Article;
import com.example.pojo.Comment;
import com.example.pojo.Result;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/add")
    public Result add(@RequestBody Comment comment, HttpSession session){
        Integer articleId=(Integer) session.getAttribute("articleId");
        Integer uid=(Integer) session.getAttribute("uid");
        comment.setUid(uid);
        Date date=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment.setCommentTime(df.format(date));
        try {
            commentService.add(comment);
            return new Result(200,"评论发布成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"评论发布失败",e);
        }
    }
    @RequestMapping("/selectByCommentId")
    public Result selectByArticleId(String commentId){
        try {
            Comment comment=commentService.selectByCommentId(Integer.valueOf(commentId));
            return new Result(200,"查询成功",comment);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new Result(500,"查询失败",e);
        }
    }
    @RequestMapping("/selectAll")
    public Result selectAll(){
        try {
            List<Comment> comments= commentService.selectAll();
            return new Result(200,"查询成功",comments);
        } catch (Exception e) {
            return new Result(500,"查询失败",e);
        }
    }
}
