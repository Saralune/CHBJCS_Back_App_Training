package com.example.apitrainings.service;

import com.example.apitrainings.Entities.Category;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface ICategoryService {

    public Category getCategoryById (Long catId);

    public Category getCategoryByName (String catName);

    public List<Category> readAllCategories();
}
