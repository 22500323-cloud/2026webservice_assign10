# Week 09 - Spring Data JPA CRUD
## 1. 프로젝트 소개
이번 과제에서는 Spring Data JPA를 사용해서 영화 정보를 관리하는 CRUD 프로그램을 만들었다.
영화의 제목, 감독, 장르, 개봉 연도, 평점, 상영 시간을 저장할 수 있도록 만들었다.
Spring Boot와 MariaDB를 연결해서 데이터를 관리하였다.

## 2. SQL 실습
SQL을 사용하여 데이터베이스와 테이블을 만들고 데이터를 추가하는 연습을 하였다.
INSERT를 사용해서 데이터를 추가하고 SELECT로 데이터를 조회하였다.
UPDATE로 데이터를 수정하고 DELETE로 데이터를 삭제하는 것도 연습하였다.

## 3. JPA 구현
이번 프로젝트에서는 Movie Entity를 만들고 JpaRepository를 사용하였다.
Controller, Service, Repository를 나누어서 코드를 작성하였다.
구현한 API는 다음과 같다.

- POST `/api/movies` : 영화 등록
![img_3.png](img_3.png)
- GET `/api/movies` : 전체 영화 조회
![img_5.png](img_5.png)
- GET `/api/movies/{id}` : 영화 한 개 조회
![img_6.png](img_6.png)
- PUT `/api/movies/{id}` : 영화 정보 수정
![img_4.png](img_4.png)
- DELETE `/api/movies/{id}` : 영화 삭제
![img_2.png](img_2.png)
Postman으로 각 API가 정상적으로 작동하는지 확인하였다.
- DBeaver 실행결과
![img_1.png](img_1.png)

## 4. SQL과 JPA 비교
SQL은 직접 쿼리문을 작성해서 데이터를 관리하는 방법이다.
JPA는 Java 객체를 사용해서 데이터베이스를 관리할 수 있다는 점이 달랐다.
처음에는 JPA 코드가 익숙하지 않았지만 Repository를 사용하면 SQL을 직접 작성하지 않아도 기본적인 CRUD 기능을 만들 수 있다는 것을 알게 되었다.

## 5. 배포 및 환경 변수
데이터베이스 연결 정보는 application.properties에 직접 작성하지 않고 환경 변수를 사용하도록 설정하였다.
DB_URL, DB_USERNAME, DB_PASSWORD를 사용하여 데이터베이스에 연결하였다.

## 6. Weekly Report
### 6-1. Key Learning
1. Entity를 사용해서 데이터베이스 테이블과 Java 객체를 연결하는 방법을 배웠다.
2. JpaRepository를 이용해서 CRUD 기능을 구현하는 방법을 배웠다.
3. Controller, Service, Repository의 역할을 구분하는 이유를 알게 되었다.

### 6-2. Problem & Solution
프로젝트를 처음 실행했을 때 패키지 경로와 import 관련 오류가 발생하였다.
각 파일의 package 선언과 import를 확인하고 수정하였다.
또한 Postman에서 PUT 요청을 보낼 때 415 오류가 발생하였다. Body를 raw JSON으로 설정하고 Content-Type을 application/json으로 변경하여 해결하였다.

### 6-3. Code Review
코드를 작성하면서 Controller에서는 요청을 받고 Service에서는 실제 기능을 처리하도록 나누었다.
Repository는 JpaRepository를 상속받아서 데이터베이스 작업을 할 수 있도록 만들었다.
이렇게 역할을 나누면 코드를 이해하고 수정하기 더 편하다는 것을 느꼈다.

### 6-4. AI Usage[AI 사용률 : 45%]
AI를 사용하여 오류가 발생한 이유를 확인하고 코드 작성 방법을 참고하였다.
AI가 알려준 코드를 그대로 사용하기보다는 프로젝트에 맞게 수정하고 IntelliJ와 Postman에서 직접 실행하여 확인하였다.
- AI 사용: 코드 작성 방법 참고 및 오류 해결
- 직접 수정: 프로젝트 패키지 구조와 코드 수정
- 직접 확인: 프로그램 실행 및 Postman CRUD 테스트

### 6-5. Reflection
이번 과제를 하면서 JPA의 기본적인 사용 방법을 배울 수 있었다.
처음에는 Entity와 Repository의 역할이 헷갈렸고 오류도 여러 번 발생하였다.
하지만 하나씩 수정하면서 CRUD 기능을 완성할 수 있었다.
앞으로는 JPA를 더 연습해서 코드를 혼자서 작성할 수 있도록 공부하고 싶다.