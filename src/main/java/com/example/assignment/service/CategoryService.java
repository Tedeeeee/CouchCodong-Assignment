package com.example.assignment.service;

import com.example.assignment.Entity.Category;
import com.example.assignment.Entity.dto.CategoryDTO;
import com.example.assignment.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public Category createCategory(CategoryDTO categoryDTO) {
        // Reposiroty 에 findByName 을 통해 데이터를 가져와 Optional 객체에 담았다.
        Optional<Category> findOne = categoryRepository.findByName(categoryDTO.getName());

        // isPresent() 메소드는 결과의 데이터 존재 여부를 확인한다. ( true or false )
        if (findOne.isPresent()) {
            // 데이터가 존재한다는 것은 중복값이 존재한다는 뜻으로 이에 해당하는 내용을 클라이언트에게 전달해주어야 한다.
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "중복된 이름입니다");
        }

        // 원래는 category 의 같은 이름으로 값을 넣지만 변수명이 같다는 것이 조금 그래서 바꿔봤다.
        // 있다면 해당 값을 Builder 를 통해 Entity 값을 새롭게 만든다.
        Category cate = Category.builder()
                .name(categoryDTO.getName())
                .build();

        // Repository 는 save(데이터 저장)기능을 제공한다.
        // 여기에 변경된 Entity 값을 넣고 리턴값으로 줬다
        return categoryRepository.save(cate);
    }

    public Category getCategoryById(Long id) {
        // Optional 객체의 능력 orElseThrow 는 id 값을 기준으로 해당 id 값인 카테고리를 가져오지만
        // 그 과정에서 해당 값을 못 가져오면 "존재하지 않는 카테고리입니다." 라는 메세지를 보낸다
        return categoryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 카테고리 입니다"));
    }
}
