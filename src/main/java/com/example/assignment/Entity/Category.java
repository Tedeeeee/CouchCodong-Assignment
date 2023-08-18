package com.example.assignment.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

// Entity 는 JPA 의 설정
// 즉 해당 클래스는 데이터베이스에서 Entity 에 해당한다는 뜻이다
@Entity
@Getter
@ToString
public class Category {

    // 해당 값은 해당 테이블의 PK 값이다 라고 선언 ( 직접 할당 )
    @Id
    // 기본 키 생성을 데이터베이스에 위임한다. ( IDENTITY )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // 해당 테이블의 컬럼 값으로 길이를 정해주고
    // 유니크를 켜주면서 중복값을 허용하지 않는다.
    @Column(length = 100, unique = true)
    String name;

    // Entity 에는 왠만하면 Setter 설정을 하지않는다.
    // 하지만 Entity 값을 아예 건들이지 않을 수 없다. 때문에 사용하는 Builder 를 등록해 놓는다.
    @Builder
    public Category(String name) {
        this.name = name;
    }
}
