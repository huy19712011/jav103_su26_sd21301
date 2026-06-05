package org.example.jav103_su26_sd21301.service;

import org.example.jav103_su26_sd21301.entity.Category;
import org.example.jav103_su26_sd21301.repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    CategoryRepository categoryRepository = new CategoryRepository();

    public List<Category> getCategories() {

        return categoryRepository.getCategories();
    }

    public Category getCategoryById(Long id) {

        return categoryRepository.getCategoryById(id);
    }
}
