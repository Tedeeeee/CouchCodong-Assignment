### 첫번째 푸쉬
- 프로젝트 생성( 사용한 Dependency )
  - Spring Boot DevTools
    - Spring 개발에 도움을 주는 도구들이 모여있는 곳이다.
  - Lombok
    - Getter, Setter, ToString, 생성자관련 어노테이션 까지 어노테이션등록 만으로 이를 해결해주는 아주 좋은 Depencency 이다
  - Spring Web
    - 해당 프레임워크로 웹 개발을 진행 할 수 있도록 도와주는 도구
    - HTTP 를 이용한 API 생성을 하도록 도와준다.
  - Spring JPA
    - Database ORM(Object Relational Mapper) 도구
    - Database 를 SQL을 통해 조작하지 않고, Object 를 생성 변경하여 조작을 할 수 있게 도와준다
    - 개발자의 입장에서는 객체를 조작하면서 데이터베이스까지 조작할 수 있는 것 처럼 보인다.
  - H2 Database
    - 데이터의 영구 저장이 아닌 메모리 저장으로 인한 휘발성 데이터 저장을 진행한다
    - 이는 상용화에 좋지 않고 주로 연습, 교육방면에서 사용된다

---
### 두번째 푸쉬
-  Controller 를 통해 DTO 의 값을 제대로 전달 받고 리턴(Response) 또한 정확히 나간다는 것을 Postman을 통해 확인 
