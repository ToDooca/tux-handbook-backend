package com.tuxhandbook.controller;

import com.tuxhandbook.entity.Category;
import com.tuxhandbook.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllCategories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{categoryId}")
    @ApiOperation(value = "", nickname = "getCategoryById")
    public ResponseEntity<Category> getCategoryById(@PathVariable String categoryId) {
        return ResponseEntity.ok(categoryService.findById(Integer.parseInt(categoryId)));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveCategory")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.update(category));
    }

    @DeleteMapping("/{categoryId}")
    @ApiOperation(value = "", nickname = "deleteCategoryById")
    public void deleteCategoryById(@PathVariable Integer categoryId) {
        categoryService.deleteById(categoryId);
    }
}
