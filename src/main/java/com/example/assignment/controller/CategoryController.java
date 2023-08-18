package com.example.assignment.controller;

import com.example.assignment.Entity.Category;
import com.example.assignment.Entity.dto.CategoryDTO;
import com.example.assignment.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("")
    public Category createCategory(@RequestBody CategoryDTO categoryDTO) {
        // 해당 값은 Category 의 값을 바로 전달한다.
        return categoryService.createCategory(categoryDTO);
    }
}
