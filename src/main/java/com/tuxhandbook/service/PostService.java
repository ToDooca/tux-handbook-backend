package com.tuxhandbook.service;

import com.tuxhandbook.entity.Post;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PostService {

    List<Post> findAll(Sort sort);

    Post findById(Integer postId);

    Post save(Post post);

    Post update(Post post);

    void deleteById(Integer postId);
}
