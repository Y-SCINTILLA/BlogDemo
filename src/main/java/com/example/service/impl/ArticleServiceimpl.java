package com.example.service.impl;

import com.example.mapper.ArticleMapper;
import com.example.pojo.Article;
import com.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ArticleServiceimpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        articleMapper.add(article);
    }

    @Override
    public Article selectByArticleId(Integer articleId) {
        return articleMapper.selectByArticleId(articleId);
    }



    @Override
    public List<Article> selectAll() {
        return articleMapper.selectAll();
    }

    @Override
    public void likes(Integer artileId) {
        articleMapper.likes(artileId);
    }

    @Override
    public void favorites(Integer articleId) {
        articleMapper.favorites(articleId);
    }
}
