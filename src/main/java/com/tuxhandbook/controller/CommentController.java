package com.tuxhandbook.controller;

import com.tuxhandbook.entity.Comment;
import com.tuxhandbook.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllComments")
    public ResponseEntity<List<Comment>> getAllComments(@RequestParam(name = "sort", required = false)Sort sort) {
        return ResponseEntity.ok(commentService.findAll(sort));
    }

    @GetMapping("/{commentId}")
    @ApiOperation(value =  "", nickname = "getCommentById")
    public ResponseEntity<Comment> getCommentById(@PathVariable String commentId) {
        return ResponseEntity.ok(commentService.findById(Integer.parseInt(commentId)));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveComment")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(comment));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateComment")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.save(comment));
    }

    @DeleteMapping("/{commentId}")
    @ApiOperation(value = "", nickname = "deleteCommentById")
    public void deleteCommentById(@PathVariable Integer commentId) {
        commentService.deleteById(commentId);
    }
}
