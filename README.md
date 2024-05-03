# 🏙 서울 공공서비스 도우미
### 내배캠 Android 트랙 최종 프로젝트

## 📌 프로젝트 소개
<p align="center">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/0ccc276e-44b1-4ba6-af7a-368f6263bb59" width="30%" height="30%">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/0f3dbe3a-4980-4c0d-a20d-6e172b4d1bd4" width="30%" height="30%">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/7c20cbe9-45f9-4f38-abfd-cae491d99d76" width="30%" height="30%">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/b0b68bf8-84d9-4e55-ae68-42d13703b238" width="30%" height="30%">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/84ee04b7-8591-4578-9bbb-0d6c6a227f69" width="30%" height="30%">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/b7c1504a-384e-4573-9fb4-47d62f530cc3" width="30%" height="30%">
</p>
> 누구나 간편하게 서울시에서 제공하는 다양한 공공서비스에서 필요로 하는 공공서비스를 찾아보고, 정보를 확인하면서 예약하는데 도움을 받을 수 있는 앱입니다. 지역별로 찾아볼 수도 있고 지도를 이용해 찾아볼 수도 있으며 여러 키워드로 추천하는 공공서비스를 만나볼 수도 있습니다.

## 📌 주요 기능
#### ✔ 서울시 공공서비스 예약 정보 확인
  :
#### ✔ 관심 지역별 공공서비스 탐색
  : 
  :  
#### ✔ 지도를 이용한 공공서비스 탐색
  : 
  : 
#### ✔ 공공서비스 저장
  : 

## 📌 담당 기능
#### • 커스텀 드롭다운 메뉴
    + DB Table, PK 및 FK 관계 설계 및 무결성에 대한 이해
    + FrontController, Controller, DAO, VO의 MVC 패턴 설계

#### • 관심지역 설정 및 변경
    + Javascript를 이용하여 구현
    + Tocken 및 Callback에 대한 이해
    
#### • 저장한 공공서비스에 대한 알림

#### • 공공서비스 랜덤 선택 배너
    + 로그인 및 회원가입
    + 관리자 페이지

#### • 지도 페이지 구성
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지

#### • 필터링 & 검색
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지

#### • 마커 생성
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지

#### • 마커 정보창 제작
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지

#### • 가로 무한 스크롤
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지

#### • 후기 작성 & 삭제 & 수정
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지

#### • 사용자 신고
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지

#### • 서버에 데이터 저장 및 불러오기
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지

#### • 앱 기반 구조 설정(BottomNavigationView, ViewPager2)
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지

#### • firebase 환경 구축 및 연동(Firestore, Storage)
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지

#### • UI 디자인 총괄(Figma)
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지

#### • 다크모드 호환(colors-night)
    + 서울을 즐겨볼래(프로그램), 커뮤니티, 관리자 페이지
    
## 📌 트러블슈팅


## 📌 사용기술
- Kotlin
- Android Jetpack
- Naver Map API

## 📌 느낀점
#### 배운 점😍
    - 6주라는 시간 동안 한 팀으로 개발을 진행하는 방법
    - 팀장으로서의 역할
    - 기획 - 개발 - 배포 - 유지보수의 사이클
    - Clean Architecture의 구조와 흐름을 알고 이를 앱에 적용하는 방법
    - NoSQL DB인 Firestore를 활용하여 데이터를 저장하고 읽고 쿼리하는 방법
    - Naver Map API를 이용하는 방법
    - Room을 구성하고 쿼리를 만드는 방법
    - Coil을 이용하여 현재 상태에 따라 sacleType과 이미지를 변경하는 방법
#### 아쉬워요😢
    - 커스텀으로 UI를 만들다 보니 생기는 다양한 예외상황에 대한 처리
    - Naver Map에서 중복좌표인 서비스들을 마커 하나에 포함시키는 방법
    - 멀티뷰타입 리사이클러뷰 안에 있는 리사이클러뷰의 무한 스크롤 기능 구현
    - 레포지토리에서 Firestore에 접근해서 값을 안전하게 반환받는 방법
    - 앱스토어 배포를 위한 비공개 유저 테스트와 심사 과정
    - UI 디자인
