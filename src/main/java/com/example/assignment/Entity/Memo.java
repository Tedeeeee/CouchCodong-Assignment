package com.example.assignment.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // 하나의 카테고리는 다양한 메모장이 존재할 수 있다.
    // fetch 는 해당 관계 데이터 즉 카테고리를 어떻게 가져오느냐에 대한 선언이다
    // EAGER 같은 경우
    @ManyToOne(fetch = FetchType.EAGER)
    // Category 의 컬럼중 id 값을 기준으로 찾아 읽는 역할을 한다.
    @JoinColumn(name = "category_id")
    Category category;

    @Column(length = 100)
    String name;

    // 해당 컬럼에 들어갈 데이터의 저장 방식은 TEXT 형식으로 저장 될 것이다.
    @Column(columnDefinition = "TEXT")
    String content;

    @Builder
    public Memo(Long id, Category category, String name, String content) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.content = content;
    }

}
