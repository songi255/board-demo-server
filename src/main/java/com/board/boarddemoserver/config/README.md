# Security Policy

## Session

가장 쉽게 적용할 수 있기 때문에 선택

현재 Session Storage 로 RDB 를 임시로 사용하고 있으며, Redis 교체필요

### JWT 교체 고려

| 비고 | Session  | JWT            |
|----|----------|----------------|
| 장점 | 보안 강화    | 서버부담 감소        |
|    | 빠른 구현    | Stateless와 매치됨 |
| 단점 | 서버 부담 증가 | 보안 약화          |


## 메소드 수준 보안 적용

- 보안적용 여부를 직관적으로 확인 가능

# JPA Config

- JPA Auditing 활성화