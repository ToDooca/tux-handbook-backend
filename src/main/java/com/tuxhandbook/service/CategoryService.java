package com.tuxhandbook.service;

import com.tuxhandbook.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer categoryId);

    Category save(Category category);

    Category update(Category category);

    void deleteById(Integer categoryId);
}
