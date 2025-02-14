package com.spring.springBootApp.service;

import com.spring.springBootApp.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    void createCategory(Category category);
    void getAllCategory();
    String deleteCategory(Long categoryId);

}
