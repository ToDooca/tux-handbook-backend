package com.tuxhandbook.repository;

import com.tuxhandbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
