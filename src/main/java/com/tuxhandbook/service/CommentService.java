package com.tuxhandbook.service;

import com.tuxhandbook.entity.Comment;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CommentService {

    List<Comment> findAll(Sort sort);

    Comment findById(Integer commentId);

    Comment save(Comment comment);

    Comment update(Comment comment);

    void deleteById(Integer commentId);
}
