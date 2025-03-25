### 1주차 시나리오
### Multi Module Design

**Multi-Module 아키텍처**를 적용하여, **각 모듈의 역할과 책임을 명확하게 분리**하고, **유지보수성과 확장성을 고려한 구조**를 설계하였습니다.

---

### Table Design

![image.png](attachment:4cbc7b96-8ed9-4949-9a8f-81d9e62806ad:image.png)

- movie 테이블 - schedule 테이블은 1:N 관계입니다
- schedule 테이블 - theater 테이블은 N:1 관계입니다.
- theater 테이블 - seat 테이블은 1:N 관계입니다.
- seat 테이블 - reservation 테이블은 1:1 관계입니다.
    - 편의를 위해 영화관 내 상영관은 하나만 있다고 가정하였습니다.
- reservation 테이블 - user 테이블은 N:1 관계입니다.

---

### Architecture

Layer Architecture를 고려하여 다음과 같은 Layer 기준으로 설계하였습니다.

- api → 외부 요청을 처리하는 레이어
- domain → 도메인 로직 및 서비스 레이어
- infra → DB, 외부 API 연동 레이어

---

### 2주차 시나리오
### 1주차 성능 테스트

![image.png](attachment:2063af7d-576c-4aa2-9d73-911013721fad:image.png)

![image.png](attachment:5de1e14f-3d82-4dfb-9f5f-34e2950901cc:image.png)

전체 요청 소요 시간 평균 18ms에 비해 서버 응답 대기시간이 17.76ms로 db에서 조회하는 시간이 대부분인 것을 알 수 있다 → DB 조회 성능 개선 필요

