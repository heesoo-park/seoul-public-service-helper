# 🏙 서울 공공서비스 도우미

**🎉근처에 있지만 알지 못했던 다양한 공공서비스를 확인하고 즐겨보세요🎉**

</br>

## 👨‍💻 프로젝트 소개
<p align="center">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/0ccc276e-44b1-4ba6-af7a-368f6263bb59" width="30%" height="30%">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/0f3dbe3a-4980-4c0d-a20d-6e172b4d1bd4" width="30%" height="30%">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/7c20cbe9-45f9-4f38-abfd-cae491d99d76" width="30%" height="30%">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/b0b68bf8-84d9-4e55-ae68-42d13703b238" width="30%" height="30%">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/84ee04b7-8591-4578-9bbb-0d6c6a227f69" width="30%" height="30%">
  <img src="https://github.com/heesoo-park/seoul-public-service-helper/assets/80674868/b7c1504a-384e-4573-9fb4-47d62f530cc3" width="30%" height="30%">
</p>

### 내배캠 Android 트랙 최종 프로젝트

> 누구나 간편하게 서울시에서 제공하는 다양한 공공서비스에서 필요로 하는 공공서비스를 찾아보고, 정보를 확인하면서 예약하는데 도움을 받을 수 있는 앱입니다. 지역별로 찾아볼 수도 있고 지도를 이용해 찾아볼 수도 있으며 여러 키워드로 추천하는 공공서비스를 만나볼 수도 있습니다

</br>

## 📌 주요 기능
#### ✔ 서울시 공공서비스 예약 정보 확인
- 앱 내의 여러 페이지에서 예약에 관련된 정보 제공
    - 요금, 서비스 대상, 예약 일자, 시간, 장소 등
- 전화나 외부 웹 사이트로 이동 가능
#### ✔ 관심 지역별 공공서비스 탐색
- 서울 지역구 중 최대 3개까지 관심 지역을 선택 및 메인 페이지에서 전환 가능
- 선택한 지역에 존재하는 공공서비스를 카테고리별로 정보 제공
- 키워드 검색을 통한 탐색 가능
#### ✔ 지도를 이용한 공공서비스 탐색
- 공공서비스 위치에 있는 마커를 통해 쉽게 위치 파악 가능
- 마커 클릭 시 나타나는 정보창으로 간단하게 정보 얻기 가능
- 다양한 필터링과 키워드 검색을 통한 탐색 가능
#### ✔ 공공서비스 저장
- 마음에 들거나 이용해보고 싶은 공공서비스 저장 가능
- 저장된 서비스에 대해서는 알림 서비스 진행
    - 예약 시작 하루 전, 예약 당일, 예약 마감 하루 전

</br>

## 📲 담당 기능
#### • 관심지역 설정 및 변경
SharedPreference, CheckBox, registerForActivityResult를 이용하여 구현

    <기능>
    1. 메인 페이지의 드롭다운 메뉴를 통한 관심지역 변경
    2. 관심지역 선택 페이지 이동
    3. 관심지역 선택 페이지를 통한 관심지역 리스트 재설정
    
#### • 저장한 공공서비스에 대한 알림
CoroutineWorker를 PeriodicWorkRequest로 만들고 WorkerManager에 enqueue하고 작업을 옵저빙하는 것으로 구현

    <기능>
    1. 1시간에 한 번씩 백그라운드에서 조건에 맞는 저장한 공공서비스가 있을 때 메인 페이지의 알림 UI 업데이트
    2. 알림 페이지에서 조건에 맞는 공공서비스 보여주기

#### • 공공서비스 랜덤 선택 배너
Room, DialogFragment, LocalDateTime, DateTimeFormatter를 이용하여 구현

    <기능>
    1. 배너를 클릭했을 때 오늘 기준 앞뒤 3일안에 예약을 시작했거나 시작할 공공서비스들 중 하나의 상세 페이지로 이동

#### • 지도 페이지 구성
Naver Map API 사용

    <기능>
    1. 맵, 마커, 현재 위치 사용
    2. 지도 위에 생성하는 마커를 통해 공공서비스 위치와 정보를 매칭시킴
    3. 현재 위치 기반으로 지도 위치를 잡아줌(서울 내부일 때는 사용자 현재 위치, 서울 외부일 때는 서울 시청을 중심으로 세팅)

#### • 필터링 & 검색
Room, SharedPreference, HashMap을 이용하여 구현

    <기능>
    1. 필터링 페이지에서 필터 옵션들을 선택하여 필터링 진행하고 실시간으로 결과 반영
    2. 선택한 필터 옵션을 지도 페이지에서 보여줌
    3. 여러 기준(카테고리, 전화번호 등)에서의 키워드 기반으로 검색 진행하고 실시간 결과 반영
    4. 다른 페이지 갔다가 돌아와도 필터링이나 검색의 결과 유지

#### • 마커 생성
Naver Map API 사용

    <기능>
    1. 대분류별 색상 지정
    2. 클릭 시 아이콘의 색상이 변경되고 카메라가 움직이며 간단하게 해당 위치의 공공서비스 정보를 볼 수 있는 마커 정보창 생성

#### • 마커 정보창 제작
ViewPager2, SharedPreference를 이용하여 구현

    <기능>
    1. 상세 정보창 이동, 저장, 공유, 외부 예약 웹 사이트 이동 가능
    2. 공공서비스 이름과 위치, 가격 정보 알 수 있음

#### • 가로 무한 스크롤
멀티뷰타입 리사이클러뷰, 고차함수, Coroutine, Room, ListAdapter를 이용하여 구현

    <기능>
    1. 왼쪽으로 스크롤을 계속 하면 현재 추천 키워드에 맞는 공공서비스가 없을 때까지 새로운 공공서비스가 5개씩 채워짐

#### • 후기 작성 & 삭제 & 수정
Firestore, Coroutine, ListAdapter를 이용하여 구현

    <기능>
    1. 한 공공서비스에 대해 사용자 당 하나의 후기를 작성할 수 있음
    2. 이미 후기를 작성했다면 수정하거나 삭제를 할 수 있음
    3. 작성 & 삭제 & 수정한 후기는 서버에 저장됨
    4. 앱 내부 캐시를 이용하여 빠르게 UI를 업데이트

#### • 사용자 신고
Firestore, 고차함수, SharedPreference, 공유 뷰모델, DialogFragment를 이용하여 구현

    <기능>
    1. 신고하려는 후기를 길게 누르면 신고 확인 창이 뜨고 확인을 누를 시 신고가 이루어짐
    2. 10회 이상 신고된 사용자는 서버 내 밴리스트에 들어가고 밴리스트에 들어가면 해당 사용자의 후기는 일반 사용자에게 보이지 않음(자신만 자신의 후기를 볼 수 있음)
    3. 한번 신고한 사용자는 다시 신고할 수 없음
    4. 자기 자신을 신고할 수 없음

#### • 서버에 데이터 저장 및 불러오기
멀티뷰타입 리사이클러뷰, 고차함수, Firestore, DialogFragment, 공유 뷰모델, SharedPreference를 이용하여 구현

    <기능>
    1. 설정 창에서 서버에 데이터 저장하기 버튼을 통해 자신의 이름, 저장한 공공서비스 리스트를 저장할 수 있고 이를 저장해놓은 위치의 키를 받을 수 있음
    2. 키를 입력하고 동기화하기 버튼을 누르면 서버에 저장되어있던 이름과 저장한 공공서비스 리스트가 현재 앱에 적용됨

#### • 앱 기반 구조 설정
BottomNavigationView와 ViewPager2의 조합으로 가장 기본 구조를 설정

    <기능>
    1. offset 조절을 통해 프래그먼트가 재생성되지 않음
    2. ViewPager2이지만 스와이프할 수 없음

#### • Firebase 환경 구축 및 연동
Firebase의 Firestore, Storage를 사용하기 위해 앱과 연결

    <기능>
    1. 사용자, 공공서비스, 후기, 밴리스트, 동기화 데이터를 Firestore에 저장
    2. 사용자 프로필 이미지 데이터를 Storage에 저장

#### • UI 디자인 총괄
Figma를 이용하여 와이어프레임을 그리고 이후 지속적인 수정을 진행

#### • 다크모드 호환
colors-night 패키지를 활용하여 진행

</br>

## ⚡ 트러블슈팅
* 로컬 캐시를 활용한 사용자 사용성 개선   
  * [Problem] 후기 기능에서 발생하는 지연시간   
  → 서버 통신 시간으로 인해 발생했지만 고정된 서버 통신 시간을 더 줄일 수 없었음

  * [TroubleShooting] 로컬 캐시 활용(메모리 단에 저장되어있는 사용자 정보)   
  → 프로필 편집이 될 때마다 로컬 캐시 값 전체 갱신   
  → 서버 통신 요청과 동시에 먼저 로컬 캐시를 가지고 UI 업데이트 진행   
  → 서버에서 돌아온 데이터는 DiffUtil 클래스에 의해 처림(*같은 서비스ID를 가졌다면 덮어쓰고, 없는 데이터라면 새로 추가)

</br>

* 중복좌표 처리를 통한 지도 사용성 향상   
  * [Problem] Room에서 데이터들을 가져와 마커로 나타내는데 예상보다 개수가 적음   
  → 중복좌표인 경우에 가장 마지막에 있는 데이터가 마커를 차지하며 생기는 문제   
  → 사용자들이 한 장소에 있는 모든 공공서비스 접근이 불가능해짐

  * [TroubleShooting] 해쉬맵과 뷰페이저2 사용   
  → HashMap<Pair<String, String>, List>의 형태로 Room에서 넘어오는 데이터들의 좌표를 키로 하여 중복좌표 데이터들을 묶음   
  → FragmentStateAdapter 대신 ListAdapter 사용하여 묶여진 데이터를 마커에 넣고 마커 클릭시 뷰페이저2의 어댑터로 넘김(좌우 스와이프를 통해 좌표가 동일한 서비스 모두 볼 수 있음)

</br>

## ❗ 느낀점
#### 배운 점😍
🎇 함께 협업 한다는 것   
👍 한 팀으로 프로젝트를 진행함에 있어 초기 단계에서의 틀을 제대로 마련하는 것이 무엇보다 중요함을 배웠습니다. 또한 짧으면 몇 주, 길면 몇 개월의 기간 동안 진행되는 프로젝트에서 리더와 팀원의 역할 그리고 서로 간 시너지가 얼마나 중요한지 느꼈습니다.
 
🎇 팀장으로서의 역할   
👍 팀장이 갖춰야할 가장 중요한 역량은 개발 실력이 아님을 느꼈습니다. 저는 팀을 조율하고 이끌어 나가는 것, 상황이나 단계에 맞게 결정을 내리는 추진력 등이 미흡했었습니다. 이번 프로젝트를 통해 뛰어난 개발 실력보다 함께하는 협업 능력이 더 중요하다는 것을 배웠습니다. 팀장으로써 계속해서 팀원의 역량을 파악하고 조율하였고, 지속적으로 소통하며 갈등 없이 프로젝트를 마무리 할 수 있었습니다.

🎇 간접적 SLDC(Software Development Life Cycle), 기획 - 개발 - 배포 – 유지보수   
👍 학부시절 혼자서 프로젝트를 진행하였을 때는 체계적인 절차에 대한 지식이 부족했고, 개발에만 포커스를 맞춰 진행하였습니다. 이번 프로젝트를 통해서 기획부터 유지보수까지의 절차를 체계적으로 경험해볼 수 있었고, 각 과정 속에서의 어려움이 무엇인지 느낄 수 있었습니다. 특히 유지보수 단계에서 유저 피드백을 받지 않을 수 있도록 완벽하게 출시하는 것은 굉장히 어렵고, 계속해서 수정될 수 있으므로 유지보수를 생각하며 개발 해야 하는 것이 중요함을 배우게 되었습니다.

🎇 MVVM 패턴의 구조와 흐름 파악 및 앱 적용   
👍 프로젝트에 MVVM 패턴을 적용해보면서 해당 아키텍처가 확실히 경계를 나눔으로써 의존성을 낮춰, 유지보수에 큰 이점이 있다는 것을 깨닫게 되었습니다. 적용하는 것이 쉽지 않았고, 아직까지는 미흡하지만 새로운 것을 함께 공부하고 적용해보는 시간을 가져봄으로써 개발에 필요한 역량을 습득할 수 있었습니다.

🎇 Firestore(NoSQL DB) 활용   
👍 처음에는 Firestore가 아닌 경험이 있는 RealtimeDB를 사용하려고 했었지만 다뤄야하는 데이터들이 많아지고 쿼리가 필요한 상황에 직면하게 되었습니다. 그래서 다른 DB의 필요성을 느꼈고, Firestore를 바로 공부하고 프로젝트에 적용시켰습니다. 처음에는 RealtimeDB와 비슷하여 접근성이 좋을 것이라고 생각했지만 어려웠습니다. 하지만, 팀끼리 DB 구조 설정부터, 데이터 추가 CRUD 관련 쿼리를 짜고, 레포지토리 단에서 Firestore 기능을 사용하는 방법을 습득하는 등 NOSQL DB를 접할 수 있었던 좋은 기회였습니다.

🎇 Naver Map API   
👍 Naver Map API는 이번에 처음 사용해보는 지도 API 이었습니다. 서울 공공서비스 도우미는 위치정보가 기반이 되는 앱입니다. Naver Map SDK 자체에서 제공하는 FusedLocationSource을 통하여 정확한 위치정보 반환이 가능하였고, 앱에 완성도를 올릴 수 있었습니다. 프래그먼트나 뷰의 형태로 사용하면 되었고 부가 설정들도 간편한 함수들을 통해 이루어져있어 안드로이드 앱 내에서 사용도 아주 편리하다는 것을 느꼈습니다.

🎇 현재 상태에 따라 scaleType과 이미지를 변경할 때 Coil 적용   
👍 이전까지는 Glide를 사용하여 scaleType과 이미지를 변경하였는데, 이번 프로텍트 팀 내에서 Coil을 사용해보자는 의견이 있었습니다. 실제로 Coil을 사용하였을 때 Glide보다 사용법이 간편하고, 다양한 기능을 제공하고 있었습니다. 하지만 자료가 많지 않아 Coil의 다양한 활용법을 익히기에는 어려움이 있었고, 여러 사이트를 참조하여 하나씩 익혀나가 프로젝트에 적용하였습니다. 새로운 라이브러리에 대한 거부감보다 기존 라이브러리와 비교하며, 더 나은 방법을 찾아가는 것 또한 개발자에게 필요한 역량임을 느낄 수 있었습니다.

#### 아쉬워요😢
💦 커스텀으로 UI를 만들다 보니 생기는 다양한 예외상황에 대한 처리   
🚩 XML 상에서 컴포넌트를 추가하여 하는 방식말고 다른 방식을 찾아보고 공부해야함

💦 Naver Map에서 중복좌표인 서비스들을 마커 하나에 포함시키는 방법   
🚩 이번에 사용한 방식은 관리하는 것에 있어서 쉽지 않았기에 좀더 효율적인 방식 필요함
 
💦 레포지토리에서 Firestore에 접근해서 값을 안전하게 반환받는 방법   
🚩 이번에는 try-catch문으로 했지만 콜백함수나 코루틴을 더욱 활용하여 해보고 싶음
