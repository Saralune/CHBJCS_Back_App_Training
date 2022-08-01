package com.example.apitrainings.service;

import com.example.apitrainings.Entities.Category;
import com.example.apitrainings.dao.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long catId) {
        return categoryRepository.findById(catId).get();
    }

    @Override
    public Category getCategoryByName(String catName) {
        return null;// categoryRepository.findByName(catName);
    }

    @Override
    public List<Category> readAllCategories() {
        return categoryRepository.findAll();
    }


}
