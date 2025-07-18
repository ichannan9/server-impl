# BoardService

Spring Boot 기반의 회원 인증(JWT)과 게시판 기능을 제공

## 실행 방법

1. MySQL 데이터베이스를 준비하고, 테이블을 생성하세요.
2. `src/main/resources/application.properties` 파일에 아래 항목을 입력하세요.
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/board_db
   spring.datasource.username=DB계정
   spring.datasource.password=DB비번
   jwt.secret=임의의문자열
   jwt.expiration=3600000
   ```
3. 아래 명령어로 서버를 실행하세요.
   ```
   ./gradlew bootRun
   ```
4. 서버 기본 포트는 8080입니다.

## 주요 기능

- 회원가입, 로그인(JWT 토큰 발급)
- 게시글 등록/조회/수정/삭제 (CRUD)
