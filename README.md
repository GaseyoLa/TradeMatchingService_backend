# 가세요라 - 백엔드

### 사용 기술
- 스프링부트
- mysql

### 라이브러리
- lombok
- jwt

## 🚀 기능 요구 사항

- [ ] 매칭 서비스를 제공하기 위한 서버와 각종 기능을 구현한다.
- [ ] 로그인 서비스: 사용자 인증을 처리하고, JWT 토큰을 생성하여 클라이언트에게 반환합니다.
- [ ] 회원 가입 서비스: 새로운 사용자의 등록을 처리하고, 회원 정보를 데이터베이스에 저장합니다.
- [ ] DB 구축: 데이터베이스를 생성하고, 필요한 테이블들을 정의합니다.
- [ ] DB 사용자 조회 서비스: 데이터베이스에서 사용자 정보를 조회하는 서비스를 제공합니다.
- [ ] 사용자 테이블 구성: 사용자 테이블을 정의하고, 필요한 컬럼들을 추가하여 사용자 정보를 저장합니다.
- [ ] 아이템 테이블 구성: 아이템 테이블을 정의하고, 아이템과 관련된 정보를 저장합니다.
- [ ] 게시물 테이블 구성: 게시물 테이블을 정의하고, 사용자가 작성한 게시물과 관련된 정보를 저장합니다.
- [ ] 옵션1, 옵션2 테이블 구성: 각각 아이템 조회 및 게시물에 필요한 옵션1, 옵션2 테이블을 정의하고, 해당 정보를 저장합니다.

## 👀 서비스 구조

```
서버
├── 사용자 서비스
│   ├── 로그인 서비스
│   ├── 회원 가입 서비스
│   
├── DB 서비스
    ├── 사용자 조회
    ├── 사용자 수정
    ├── 사용자 저장
    ├── 사용자 삭제

데이터베이스
├── 테이블 명
    ├── 사용자 테이블 (USER)
    │   ├── ID(PR)
    │   ├── 닉네임
    │   ├── 이메일
    │   ├── 디코
    │   ├── 메이플월드 해시태그
    │   ├── 작성 게시물ID(FK)
    │   ├── 별점
    │   
    ├── 아이템 테이블
    │   ├── ID
    │   ├── 이름
    │   ├── 카테고리ID(FK)
    │   ├── 옵션1(FK)
    │   ├── 공격력
    │   ├── 마력
    │   ├── 공격속도
    │   ├── 가능횟수
    │   
    ├── 게시물 테이블
    │   ├── ID
    │   ├── 작성자ID(FK)
    │   ├── 아이템ID(FK)
    │   ├── 옵션2
    │   ├── 가격
    │   
    ├── 카테고리 테이블
    │   ├── ID
    │   ├── 카테고리 이름
    │   
    ├── 옵션1 테이블 (아이템 조회용)
    │   ├── ID
    │   ├── 공격력
    │   ├── 마력
    │   ├── ...
    │   
    ├── 옵션2 테이블 (게시물용)
        ├── ID
        ├── 공격력
        ├── 마력

```


## 🎯 프로그래밍 사항

- JDK 17 버전
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.



## ✏️ 참고 사항

- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
  - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.

  ### 테스트 실행 가이드

- 터미널에서 `java -version`을 실행하여 Java 버전이 17인지 확인한다.
  Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 17로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,
  Windows 사용자의 경우 `gradlew.bat clean test` 또는 `./gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---