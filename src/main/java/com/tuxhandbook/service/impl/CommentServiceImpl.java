package com.tuxhandbook.service.impl;

import com.tuxhandbook.entity.Comment;
import com.tuxhandbook.repository.CommentRepository;
import com.tuxhandbook.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> findAll(Sort sort) {
        return commentRepository.findAll(sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public Comment findById(Integer commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("CommentServiceImpl.comment.notFound"));
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(Integer commentId) {
        commentRepository.deleteById(commentId);
    }
}
