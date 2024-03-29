package com.appnotespring.service;

import com.appnotespring.entity.Category;
import com.appnotespring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

public void deleteCategory(int id){
        categoryRepository.deleteById(id);
}

public Category editCategory(Category category){
        return categoryRepository.save(category);
}
}
