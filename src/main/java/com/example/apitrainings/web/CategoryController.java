package com.example.apitrainings.web;


import com.example.apitrainings.Entities.Category;
import com.example.apitrainings.Entities.Training;
import com.example.apitrainings.service.CategoryServiceImpl;
import com.example.apitrainings.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ImplTrainingService trainingService;

    @GetMapping("/categories")
    public List<Category> allCategories() {
        return categoryService.readAllCategories();
    }

    @GetMapping("/categories/{id}/trainings")
    public List<Training> allTrainingsByCatId(@PathVariable ("id") Long id)
    { return trainingService.readTrainingsByCategoryId(id);}
}
