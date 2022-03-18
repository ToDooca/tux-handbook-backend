package com.tuxhandbook.service.impl;

import com.tuxhandbook.entity.Post;
import com.tuxhandbook.repository.PostRepository;
import com.tuxhandbook.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public List<Post> findAll(Sort sort) {
        return postRepository.findAll(sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public Post findById(Integer postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("PostServiceImpl.post.notFound"));
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(Integer postId) {
        postRepository.deleteById(postId);
    }
}
