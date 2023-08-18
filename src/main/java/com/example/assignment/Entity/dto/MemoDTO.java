package com.example.assignment.Entity.dto;

import lombok.Data;

@Data
public class MemoDTO {
    Long memo_id;
    Long category_id;
    String name;
    String content;
}
