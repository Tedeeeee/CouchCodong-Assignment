package com.example.assignment.controller;

import com.example.assignment.Entity.dto.CategoryDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @PostMapping("")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryDTO;
    }
}
