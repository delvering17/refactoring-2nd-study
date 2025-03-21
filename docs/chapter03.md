# Chapter03 - 코드에서 나는 악취

### 3.1 기이한 이름

- 함수, 모듈, 변수, 클래스 등은 그 이름만 보고도 각각이 무슨 일을 하고 어떻게 사용해야 하는지 명확히 알 수 있도록 엄청나게 신경 써서 이름을 지어야한다.

### 3.2 중복 코드

- 코드가 비슷하긴 한데 완전히 똑같지는 않다면, 먼저 문장 슬라이드하기로 비슷한 부분을 한곳에 모아 함수 추출하기를 더 쉽게 적용할 수 있는지 살펴본다.

### 3.3 긴 함수

- 코드를 이해하고, 공유하고, 선택하기 쉬워진다는 장점은 함수를 짧게 구성할 때 나오는 것이다.
- ‘무엇을 하는지’를 코드가 잘 설명해주지 못할수록 함수로 만드는 게 유리하다.

### 3.4 긴 매개변수 목록

- 클래스는 매개변수 목록을 줄이는 데 효과적인 수단이다.

### 3.5 전역 데이터

- 전역 데이터는 코드베이스 어디에서든 건드릴 수 있고 값을 누가 바꿨는지 찾아낼 매커니즘이 없다는 게 문제다.
- 전역 데이터가 아주 조금만 있더라도 캡슐화하는 편이다.

### 3.6 가변 데이터

- 함수형 프로그램이에서는 데이터는 절대 변하지 않고, 데이터를 변경하려면 반드시 변경하려는 값에 해당하는 복사본을 만들어서 반환한다는 개념을 기본으로 삼고있다.

### 3.7 뒤엉킨 변경

- 뒤엉킨 변경은 단일 책임 원칙(SRP)이 제대로 지켜지지 않을 떄 나타난다.

### 3.8 산탄총 수술

- 변경할 부분이 코드 전반에 퍼져있다면 찾기도 어렵고 꼭 수정해야 할 곳을 지나치기 쉽다.

### 3.9 기능 편애

- 기능 편애는 흔히 어떤 함수가 자기가 속한 모듈의 함수나 데이터보다 다른 모듈의 함수나 데이터와 상호작용 할 일이 더 많을 떄 풍기는 냄새다.

### 3.10 데이터 뭉치

- 데이터 뭉친인지 판별하려면  하나를 삭제해보자. 그랬을 때 나머지

### 3.12 반복되는 switch문

- 중복된 switch문이 문제가 되는 이유는 조건절을 하나 추가할 때마다 다른 switch문들도 모두 찾아서 함께 수정해야하기 때문이다. → 다형성으로 해결

### 3.16 임시 필드

- 간혹 특정 상황에서만 값이 설정 되는 필드를 가진 클래스도 있다. … 이렇게 임시 필드를 갖도록 작성하면 코드를 이해하기 어렵다. 그래서 사용자는 쓰이지 않는 것처럼 보이는 필드가 존재하는 이유를 파악하느라 머리를 싸매게 된다.

### 3.22 데이터 클래스

- 특히 다른 함수를 호출해 얻은 결과 레코드(데이터객체)로는 동작 코드를 넣을 이유가 없다. 대표적인 예로 단계 쪼개기의 겨로가로 나온 중간 데이터 구조가 있다. 이런 데이터 구조는 불변이다. 불편필드는 굳이 캡슐화할 필요가 없고, 불변 데이터로부터 나오는 정보는 게터를 통하지 않고 그냥 필드 자체를 공개해도 된다.

### 3.24 주석

- 주석은 악취가 아닌 향기를 입힌다. 문제는 주석을 탈취제처럼 사용하는 데 있다. 주석이 장황하게 달린 원인이 코드를 잘못 작성했기 때문인 경우가 의외로 많다.
