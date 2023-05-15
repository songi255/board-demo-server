# 진행상황

## endpoints
- `GET:/post` : 모든 게시물 반환
- `GET:/post/{no}` : 게시물 열람 
- `POST:/post` : 게시물 등록
- `PUT:/post{no}` : 게시물 수정
- `Delete:/post{no}` : 게시물 삭제

- `POST:/login` : 로그인
- `POST:/logout` : 로그아웃

## Todos

- 기본 CRUD 완성
- method 보안 적용
- aggregate endpoint 에 paging 적용
- 조회용 쿼리스트링 처리 추가
- PasswordEncoder 적용
- dto 객체 명세
- response 응답내용 및 httpStatus 확인
- Logging 추가
- Test 코드 작성
- Docs 작성
- HATEOAS 적용
- Comment 기능 추가

## Issue
- JPA User Table 생성 오류
- JPA join issue
- spring security 기본 /login endpoint 해제 여부 확인
  - /signin 으로 변경 고려

# run

## h2 console

`localhost:8080/h2-console` 접속
- `jdbc url` : jdbc:h2:mem:h2-test
- `user name` : admin
- `password` : 1234

# Deploy

Docker 환경변수로 secret 입력할 것

- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`
