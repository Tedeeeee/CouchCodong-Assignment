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

--- 
### 세번째 푸쉬
- Entity 에 JPA 를 활용하여 객체를 조정해서 진행하는 과정을 보여준다. 다양한 기능이 있다는 것을 보여준다.
- Entity 에 사용된 JPA 는 주석처리로 설명을 해놓았다.

---
### 네번째 푸쉬
- Entity 와 Controller 를 연결하고 원하는 Service 를 만들기
- 데이터 베이스와 가까운 Repository 생성
  1. 인터페이스를 통해 Repository 설정 ( 데이터를 어떻게 다룰까 하는 추상메소드 작성 )
  2. Repository 는 JPA 를 상속시켜 주는데 제네릭 값으로는 <다룰값, 다룰 객체의 id 값(Long)> 으로 지정한다.
  3. JPA 는 기본적으로 findById, findAll, save, delete 등 다양한 로직을 제공한다.
  4. Optional 은 null 값을 가질수 있는 Category 객체를 만들어 준다.
  5. 또한 Optional 은 isEmpty, elseOrThrow, isPresent 등 코드를 더욱 깔끔하게 작성할 수 있게 해준다.
- Service 생성 ( Repository 를 의존성 주입하여 생성)
  1. Service 는 클라이언트(소비자)에 가깝게 위치해 있는 클래스이다.
  2. 사용자가 느낄 수 있는 기본적인 기능을 준다. ( EX)createCategory )
  3. service 의 메소드 내용은 안에 적어놓았습니다.
- Controller 변경
  1. 맨처음 만들어 주었던 Controller 의 기능을 조금 바꿔주었다.
  2. 처음에는 그저 데이터가 잘 들어오는지만 확인하는 controller 에서 카테고리를 만들어주는 controller 로 변환
