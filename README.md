# AwsStudyBook
kkh's github

-----

# 공부내용 정리 

## 2022-08-16
규모있는 프로젝트 진행시 데이터 조회는 Entity 클래스만으로 처리하기 어려워 조회용 프레임워크를 추가로 사용

대표적 예시 : querydsl, jooq, MyBatis 등이 있음. 

등록/수정/삭제 등은 SpringDataJpa를 통해 진행

- querydsl 추천 이유
1. 타입 안정성
    1. 오타나 존재하지않는 컬럼명 명시할 경우 IDE에서 검출
    MyBatis는 해당 내용 없음.
2. 많은 회사 사용
    1. 쿠팡,배민 등 JPA를 적극적으로 사용하는 회사에서 Querydsl를 적극적으로 사용한다.
