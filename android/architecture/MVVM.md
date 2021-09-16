# MVVM 패턴

참고주소 - [안드로이드 가이드](https://developer.android.com/jetpack/guide?hl=ko), [안드로이드 패턴](https://academy.realm.io/kr/posts/eric-maxwell-mvc-mvp-and-mvvm-on-android/)

<img src ="https://developer.android.com/topic/libraries/architecture/images/final-architecture.png?hl=ko">

## 장점
1. Model과 View, View와 Viewmodel 사이의 의존성이 없다
2. 테스팅을 위해 가상 뷰를 만들 이유가 없다.

## 단점
1. 유지 관리가 힘들다

## ViewModel Factory
뷰모델 팩토리를 사용하는 이유 <br>
-> 뷰모델 인스턴스를 만들 수 있기 때문이다.

