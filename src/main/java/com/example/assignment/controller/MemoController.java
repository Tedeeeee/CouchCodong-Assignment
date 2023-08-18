package com.example.assignment.controller;

import com.example.assignment.Entity.Memo;
import com.example.assignment.Entity.dto.MemoDTO;
import com.example.assignment.service.MemoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memos")
@AllArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @PostMapping("")
    public Memo createMemo(@RequestBody MemoDTO memoDTO) {
        return memoService.createMemo(memoDTO);
    }

    @GetMapping("/{id}")
    public Memo getMemo(@PathVariable Long id) {
        return memoService.getMemo(id);
    }

    @PutMapping("")
    public Memo MemoUpdate(@RequestBody MemoDTO memoDTO) {
        return memoService.MemoUpdate(memoDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteMemo(@PathVariable Long id) {
        return memoService.deleteMemo(id);
    }

    @GetMapping("/all/{categoryId}")
    public List<Memo> getAllMemo(@PathVariable Long categoryId) {
        return memoService.findAllMemo(categoryId);
    }
}
