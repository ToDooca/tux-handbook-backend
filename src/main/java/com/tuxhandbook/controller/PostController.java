package com.tuxhandbook.controller;

import com.tuxhandbook.entity.Post;
import com.tuxhandbook.service.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllPosts")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(name = "sort", required = false)Sort sort) {
        return ResponseEntity.ok(postService.findAll(sort));
    }

    @GetMapping("/{postId}")
    @ApiOperation(value = "", nickname = "getPostById")
    public ResponseEntity<Post> getPostById(@PathVariable String postId) {
        return ResponseEntity.ok(postService.findById(Integer.parseInt(postId)));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "savePost")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updatePost")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.save(post));
    }

    @DeleteMapping("/{postId}")
    @ApiOperation(value = "", nickname = "deletePostById")
    public void deletePostById(@PathVariable Integer postId) {
        postService.deleteById(postId);
    }
}
