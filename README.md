# 옷 쇼핑몰 Uniplo 백엔드 팀 프로젝트

## 1. 프로젝트 소개

본 프로젝트는 Spring Boot 기반의 의류 쇼핑몰 백엔드 API 서버입니다. 단순히 상품을 판매하는 것을 넘어, **복잡한 주문 상태(취소, 반품, 교환 등)를 체계적으로 관리**하고, 안정적인 게시판 및 회원 관리 기능을 제공하는 것을 목표로 했습니다. 이 과정을 통해 **대용량 트래픽과 복잡한 비즈니스 로직에 대응할 수 있는 백엔드 시스템 설계 역량**을 기르고자 했습니다.

### 팀원 및 역할
| 이름   | 역할             | 주요 담당 기능            |
| ------ | ---------------- | ------------------------- |
| 김모세 | 팀장, 백엔드 개발 | 회원가입, 게시판, DB 설계 |
| 이주열 | 백엔드 개발      | 쇼핑 아이템 관리          |
| 방해준 | 백엔드 개발      | 게시판 기능               |
| 방서연 | 백엔드 개발      | 장바구니 기능             |

## 2. 데이터베이스 설계 (ERD)

<details>
<summary> 전체 ERD 다이어그램 보기 (클릭)</summary>
<br>
<img width="100%" alt="쇼핑몰 DB 설계" src="https://github.com/user-attachments/assets/7f965626-e867-45f4-9389-6a57f8d002b8" />
</details>

### 💡 DB 설계 핵심 고민: 복잡한 주문 상태 관리

<details>
<summary> ERD 다이어그램 중 설계를 맡은 주문취소, 반품, 환불, 교환 (클릭)</summary>
<br>
<img width="1070" height="645" alt="image" src="https://github.com/user-attachments/assets/7ac2bff2-8e09-4446-bb88-ed7e94d25832" />
</details>


#### 챌린지 (Problem)
주문 취소, 교환, 환불 등은 배송 상태(배송 전, 배송 중 등)와 밀접하게 연관되어 복잡한 상태 변화를 가집니다. 예를 들어, '배송 전' 주문은 즉시 취소 가능하지만, '배송 완료' 후에는 '반품' 절차를 거쳐야 합니다. 이러한 복잡성을 체계적으로 관리하지 않으면 데이터 불일치 및 서비스 장애로 이어질 수 있습니다.

#### 해결 방안 (Solution)
1.  **상태 컬럼 도입**: `orders`, `refunds` 등 주요 엔티티에 `status`와 같은 상태 관리 컬럼을 추가하여 각 엔티티의 현재 상태를 명확히 추적하도록 했습니다.
2.  **상태 관리 테이블**: 모든 상태(예: '환불대기', '환불완료')를 별도의 `status_management` 테이블에서 코드로 관리하여 일관성을 유지하고, 향후 상태 추가/변경에 유연하게 대처할 수 있도록 설계했습니다.

#### 기대 효과 (Result)
*   **데이터 정합성 확보**: 모든 주문 관련 프로세스가 명확한 상태 값을 기반으로 동작하므로 데이터 불일치 가능성을 최소화했습니다.
*   **유지보수성 향상**: 향후 새로운 주문 상태(예: '부분환불')가 추가되더라도, `status_management` 테이블에 코드만 추가하면 되므로 비즈니스 로직 변경을 최소화할 수 있습니다.


## 3. 기술 스택
| 구분        | 기술                   | 비고                               |
| ----------- | ---------------------- |----------------------------------|
| Language    | Java 17                |                                  |
| Framework   | Spring Boot 3.x        |                                  |
| Database    | MySQL 8.0              |                                  |
| Persistence | MyBatis                | SQL을 직접 제어하여 튜닝의 유연성을 확보하기 위해 선택 |
| View        | JSP (JavaServer Pages) |                                  |
| Build Tool  | Gradle                 |                                  |

### 3. Persistence Layer: 왜 MyBatis를 선택했는가?

이 프로젝트에서는 JPA 대신 MyBatis를 데이터 영속성 기술로 선택했습니다. 주요 이유는 다음과 같습니다.
+ SQL에 대한 완전한 제어: 쇼핑몰 백엔드는 복잡한 조건의 상품 조회, 통계, 주문 내역 등 성능에 민감한 쿼리가 많을 것으로 예상했습니다. MyBatis를 사용하면 SQL을 XML에 직접 작성하여 실행 계획을 분석하고, 인덱스 사용을 유도하는 등 세밀한 튜닝이 가능하다고 판단했습니다.
+ 낮은 러닝 커브와 명확성: 팀원들이 SQL에 익숙했기 때문에, 영속성 컨텍스트와 같은 JPA의 내부 동작 원리를 깊이 학습하는 데 드는 시간을 줄이고 빠르게 개발에 집중할 수 있었습니다. SQL이 XML에 명확하게 드러나 있어 어떤 쿼리가 실행되는지 직관적으로 파악하기 용이했습니다.
+ 유연한 동적 SQL: 사용자의 검색 조건, 정렬 기준 등에 따라 동적으로 쿼리를 생성해야 하는 경우가 많습니다. MyBatis의 동적 SQL 기능(<if>, <choose>, <foreach> 등)은 이러한 요구사항을 효과적으로 처리할 수 있는 강력한 도구였습니다.
+ 물론, 객체와 테이블 간의 반복적인 매핑 작업(Boilerplate code)이 필요하다는 단점도 인지하고 있으며, 이는 '향후 개선 및 고려사항'에서 언급한 것처럼 생산성이 높은 JPA 도입을 고려하게 된 계기가 되었습니다.



## 4. API 명세
<details>
<summary>API 명세서 보기 (클릭)</summary>

| 기능     | HTTP Method | URI                  | 설명                 |
| :------- | :---------- | :------------------- | :------------------- |
| **회원** | `POST`      | `/users/signup`      | 회원가입             |
|          | `POST`      | `/users/login`       | 로그인               |
|          | `GET`       | `/users/check-id`    | 아이디 중복 확인     |
| **게시판** | `POST`      | `/posts`             | 게시글 작성          |
|          | `GET`       | `/posts`             | 게시글 목록 조회     |
|          | `GET`       | `/posts/{id}`        | 게시글 상세 조회     |
|          | `PUT`       | `/posts/{id}`        | 게시글 수정          |
|          | `DELETE`    | `/posts/{id}`        | 게시글 삭제          |

</details>

## 5. Technical Deep Dive

### 1. 전역 예외 처리 (Global Exception Handling)
`@RestControllerAdvice`를 사용하여 중복되는 예외 처리 코드를 분리하고, 모든 API에 일관된 형식의 에러 응답을 제공하도록 설계했습니다. 예를 들어, 존재하지 않는 게시글 조회 시 `PostNotFoundException`이 발생하면 클라이언트는 아래와 같은 `404 Not Found` 응답을 받게 됩니다.

```java
// GlobalExceptionHandler.java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePostNotFoundException(PostNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
```
**에러 응답 예시**
```json
{
    "status": 404,
    "message": "해당 게시글을 찾을 수 없습니다."
}
```

### 2. 비밀번호 암호화
사용자의 개인정보 보호를 위해 `BCryptPasswordEncoder`를 사용하여 비밀번호를 안전하게 암호화했습니다. BCrypt는 Salt를 포함한 단방향 해시 함수로, 데이터베이스가 유출되더라도 원본 비밀번호를 복원하기 어렵게 만듭니다.

```java
// UserService.java
public void signup(UserDto user) {
    // ...
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    userRepository.save(user);
}
```

## 6. 프로젝트 실행 방법
1.  프로젝트 클론
    ```bash
    git clone https://github.com/your-repo/uniplo-backend.git
    ```
2.  `application.properties` 설정
    - 본인의 MySQL 환경에 맞게 `datasource` 정보를 수정합니다.
3.  애플리케이션 실행
    ```bash
    ./gradlew bootRun
    ```

## 7. 향후 개선 및 고려사항
*   **MyBatis의 한계와 JPA 도입**: 관계형 데이터베이스와 객체 지향 패러다임의 불일치 문제로 인해, DTO나 테이블 스키마 변경 시 MyBatis Mapper, Repository, Service, Controller에 걸쳐 수정이 필요한 경우가 많습니다. 향후 유지보수성 향상을 위해 JPA 도입을 고려할 수 있습니다.
*   **인증/인가 고도화**: 현재 세션 기반의 로그인 방식을 향후 Spring Security와 JWT(Json Web Token)를 사용한 인증/인가 방식으로 고도화할 수 있습니다. 더 나아가 OAuth2를 활용한 소셜 로그인 기능 도입도 가능합니다.
