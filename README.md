# 자취생을 부탁해

냉장고에 있는 재료를 입력하면 요리를 추천해주는 서비스

자취생을 위한 요리 추천 서비스


## What is different?

#### 재료를 기준으로 검색한다

자취생을 부탁해 ; 냉장고속 재료 아무거나 입력하면 가능한 음식 추천해줌. 자취생맞춤!

ex ) 소고기 검색 => 소고기가 주 재료로 들어가는 음식 추천 (갈비, 갈비찜, 장조림 등등)

기존 사이트 ; 레시피 이름을 기준으로 추천

ex) 소고기 검색 => 소고기 야채말이, 맛있는 소고기덮밥, 소고기를 넣은 떡국레시피... (이름에 소고기가 들어가야 함)


#### 음식 종류를 바로 확인할 수 있다

자취생을 부탁해 ; 음식 종류로 추천해준다. 오늘 뭐 먹지! 고민 노노

ex ) 소고기 검색 => 소고기가 들어가는 음식 추천 (갈비, 갈비찜, 장조림 등등)

기존 사이트 ; 레시피를 기준으로 추천

ex) 소고기 검색 => 소고기덮밥, 맛있는 소고기덮밥, 백종원 소고기덮밥, 데리야끼 소고기덮밥...


## 프로젝트 설명


### 게시판 기능

- 검색창 : 요리를 검색한다

- 게시판 : 요리 레시피를 올린다

### key summary

모든 기능을 Unit test로 작성 (UI 클릭이벤트는 제외하고)

모든 기능 테스트 통과

### Folder structure

```
┬──gradle/wrapper : gradle wrapper
│
├──srcipts : 자동빌드/배포 스크립트 
│
├──src
│   ├── main
│   │     ├───springboot
│   │     │       ├─
│
├──
```


    게시판 기능 설명

    Key summary

        포트폴리오에서 강조하고 싶은 내용들을 적습니다. 예를 들어 유닛테스트 Code coverage가 100%라면 적어도 됩니다. 

    Folder structure 소개

    Backend architecture

        Routes/Endpoints 소개

        Controller, Service, Repository, Store procedure 관계도

        DB 스키마

    Frontend architecture

        React라면 Redux pattern의 역할 소개

    설치 방법

    실행 방법

    향후 추가 할 기능들



## TODO

- 기본 기능 넣기
- 카카오 로그인
- AI 추천 넣기
- 무중단배포 지금 nginx인데 docker로 바꾸기
- 사진에서 재료 추출
- 사진 aws에 업로드 / 다운로드 기능
- 보안 신경쓰기 : sql 인젝션 등...
- https 추가
- 게시판 기능 추가
- 난이도 별표시
- 로그인해서 하트 누르기 -> 내 찜
- 바둑판모드 / 리스트모드
- card bottom 으로 재료 or  하트찜


## 기술 스택

- java
- spring boot
- jpa
- aws
- tdd
- ci/cd (travis, nginx -> docker)
- mustache
- html/css/js
- jquery + ajax
- 노드js로 하는게 더 재밌었겠다 
- 웹프론트 똥
