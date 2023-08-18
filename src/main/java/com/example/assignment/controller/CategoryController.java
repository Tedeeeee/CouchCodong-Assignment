package com.example.assignment.controller;

import com.example.assignment.Entity.Category;
import com.example.assignment.Entity.dto.CategoryDTO;
import com.example.assignment.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        // id 값을 기준으로 해당 카테고리를 불러온다.
        return categoryService.getCategoryById(id);
    }

    @GetMapping("")
    public Page<Category> getCategories(Pageable pageable, @RequestParam String keyword) {
        return categoryService.getCategories(pageable, keyword);
    }


}
