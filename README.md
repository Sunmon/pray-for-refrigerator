# 자취생을 부탁해

냉장고에 있는 재료를 입력하면 요리를 추천해주는 서비스

자취생을 위한 요리 추천 서비스

![image](https://user-images.githubusercontent.com/26290571/80666495-595b9f80-8ad7-11ea-93ce-c0a779204c9b.png){: width="50%" height="50%"}



## What is different?

#### 재료를 기준으로 검색한다

> 예) '소고기' 검색

`자취생을 부탁해` ; 냉장고속 재료 아무거나 입력하면 가능한 음식 추천해줌. 자취생맞춤!

  => 소고기가 주 재료로 들어가는 음식 추천 (갈비, 갈비찜, 장조림 등등)

`기존 사이트` ; 레시피 이름을 기준으로 추천
  
 => 소고기 야채말이, 맛있는 소고기덮밥, 소고기를 넣은 떡국레시피... (이름에 소고기가 들어가야 함)


#### 음식 종류를 바로 확인할 수 있다

> 예) '소고기' 검색

`자취생을 부탁해` ; 음식 종류로 추천해준다. 오늘 뭐 먹지! 고민고민하지마걸

=> 소고기가 들어가는 음식 추천 (갈비, 갈비찜, 장조림 등등)

`기존 사이트` ; 레시피를 기준으로 추천

=> 소고기덮밥, 맛있는 소고기덮밥, 백종원 소고기덮밥, 데리야끼 소고기덮밥...


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
│   │     │       ├─ config : 로그인, OAuth, Security 관련 클래스 모음
│   │     │       ├─ domain : JPA entity 모음
│   │     │       ├─ service: 서비스 클래스 모음. 트랜젝션
│   │     │       └─ web : DTO와 컨트롤러 모음
│   │     └───resources
│   │             ├─ static : css, image, js 모음
│   │             ├─ templates : .mustache 모음(html 대체)
│   │             └──application.properties : 어플리케이션 프로퍼티 + 무중단 배포용 포트 다른거
│   │ 
│   └── test
│         ├───springboot : 유닛테스트 모음
│         └───resources : 테스트 리소스 
│
├── travis.yml : travis 설정
├── appsec.yml : AWS codeDeploy 설정
├── build.gradle : gradle build
└─── *.sql : 게시판 post작성 / 레시피  sql들

```

### Backend architecture

#### Controllers 

- IndexController : 메인페이지 컨트롤러. 레시피 검색 / 게시판 호출. 다른 컨트롤러와 연결.
- PostsApiController : 게시판 관련 컨트롤러. 글 올리기 / 수정/ 삭제/ 열람. PostService와 연결
- ProfileController : 상태 관련 컨트롤러. 현재 열린 프로퍼티가 뭔지 확인용도
- RecipeApiController : 레시피 검색 관련 컨트롤러. RecipeService와 연결

#### Service

- PostService : 게시글 저장, 업데이트, 조회, 삭제 기능
- RecipeService : 레시피 저장, 검색, 조회기능. 

#### Domain

- Posts : 게시글 엔티티
- Food : 음식 엔티티. ID, 음식이름(잔치국수), 종류(면), 이미지
- Ingredient: 재료 엔티티. ID, 재료이름(소고기), 종류(고기) 저장
- Recipe : 레시피 엔티티. 음식별로 필요한 재료 저장. Food와 Ingredient를 FK로 받는다. 


### Frontend architecture

- .mustache : 머스타치 템플릿 엔진 소스
- index.js : 메인화면 js
- recipeBoard.js : 게시판 js
- recipeSearch.js : 레시피 검색 js. 검색기능 ajax로 처리

## 사이트 주소

www.pray-refrigerator.com

## TODO

기능 추가 (중간줄은 완료)

작은 기능

- ~검색내용 없으면 엔터쳐도 안 넘어가게~
- ~재료 검색 ajax로직 리팩토링~ 
- ~필터 적용~
- 카카오 로그인
- 사진 aws에 업로드 / 다운로드 기능
- 게시판 기능 보완
- 음식 난이도 별표시
- 바둑판모드 / 리스트모드
- 로그인해서 하트 누르기 -> 내 찜
- card bottom 으로 재료 or  하트찜

천천히 할 기능

- 사진에서 재료 추출
- 찜 목록 기반으로 AI 추천 넣기
- UI 


기타 추가

- 보안 신경쓰기 : sql 인젝션 등...
- https 추가

- 무중단배포 지금 nginx인데 docker로 바꾸기


## 기술 스택

- java
- spring boot
- jpa
- aws
- tdd
- ci/cd (travis)
- mustache
- html/css/js
- jquery + ajax
