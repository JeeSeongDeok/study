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

## Roomdb에 ViewModel
참고주소 - [안드로이드 가이드](https://developer.android.com/codelabs/android-room-with-a-view-kotlin?hl=ko#0)


# MVVM에 대한 고찰

## 1. View가 여러개의 ViewModel을 가져도 되는 것인가?
사람A:
Google suggests that you use 1 ViewModel per View (i.e., Activity or Fragment) (see https://youtu.be/Ts-uxYiBEQ8?t=8m40s), and then inside each ViewModel you can have more than 1 type of Model. However, the MVVM principle is to have only 1 Model type per ViewModel, so Google's presentation contradicts that :/. I guess you'll have to decide what approach works better for your app.
구글에 따르면 뷰마다 뷰모델은 1개를 사용한다. 뷰모델은 1개 이상의 모델을 가질 수 있다.
그러나 MVVM 원리에 따르면 뷰모델마다 모델은 1개를 사용한다.
구글의 프레젠테이션은 모순적이다.
사람B:
One view model is standard. However, even google suggests that you may have more than one view model. That comes quite convenient when you mitgrate a phone app towards a tablet app. When you combind more than one phone views on a single tab view, then it is convenient re-using the models.
하나의 뷰모델이 표준이다. 그러나 구글은 너가 하나 이상의 뷰모델을 가질 수 있다고 했다. 이건 폰 앱에서 테이블 앱으로 이관될 때 굉장히 편하다. 하나 이상의 폰 뷰들을 하나의 탭 뷰로 합칠 때 모델을 재사용함에 편리하다.
If you have the SOLID principles in mind when coding, then the S (single responsibitly of a class) may cause you to use more than one view model.
코딩할 때 SOLID 원리를 따르는 자라면 S 는 하나의 뷰모델을 사용하게 한다. S 는 클래스는 단일 역할의 책임이 있다는 걸 뜻함.
However, one per view is pretty much standard and you shold have reasons, as metioned above, to use more than one.
그러나 뷰마다 하나가 있는 게 표준이며, 너는 위에 처럼 한 개 이상을 써야 하는 이유들도 있다.

사람A:
Don't place your ViewModel into another ViewModel. You should provide your ViewModel from ViewModelProviders. ViewModelProviders needs a context to create your ViewModel with given type.
뷰모델 안에 다른 뷰모델을 갖게 하지 말아라. ViewModelProviders 로부터 뷰모델을 제공할 수 있다.
There is nothing wrong with providing multiple ViewModel for a single activity.
단일 액티비티에 대해 여러 뷰모델을 제공하는 건 잘못되지 않았다.
사람B:
Sometimes you need composition in the view model layer though. Some view models can be "derived" from others. You don't want to have this logic in the presentation layer.
그래도 뷰모델 레이어에 콤포지션 해야 할 때가 있을 것이다. 어떤 뷰모델은 다른 것들로부터 "derived" 될 수 있다. 너는 프레젠테이션 레이어에서 이 로직을 갖길 원하지 않을 것이다.

사람A:
I think having multiple viewmodels per activity only increases complexity and I do not see any value in doing that.
액티비티마다 여러 뷰모델을 갖게 하는 건 복잡도를 올린다. 그리고 어느 가치도 없어 보인다.
사람B:
According to the open/closed principle, you should create three different ViewModels. The complexity isn't increased that much, and you are gaining the ability to move one ViewModel (or just reuse it) with the corresponding RecyclerView to the another Activity very easily.
o/cp 원리에 따르면, 3개의 다른 뷰모델을 만들어야만 한다. 복잡도는 많이 증가하지 않고, 하나의 뷰모델을 상응하는 리사이클러뷰와 함께 쉽게 다른 액티비티로 옮길 수 있는 능력을 갖게 된다.


Pattern
MVVM - ViewModel
프로파일
 강동원 ・ 2018. 9. 3. 16:05
URL 복사  이웃추가 
Q: 뷰에는 하나의 뷰모델만 있어야 하는가?

사람A:
Google suggests that you use 1 ViewModel per View (i.e., Activity or Fragment) (see https://youtu.be/Ts-uxYiBEQ8?t=8m40s), and then inside each ViewModel you can have more than 1 type of Model. However, the MVVM principle is to have only 1 Model type per ViewModel, so Google's presentation contradicts that :/. I guess you'll have to decide what approach works better for your app.
구글에 따르면 뷰마다 뷰모델은 1개를 사용한다. 뷰모델은 1개 이상의 모델을 가질 수 있다.
그러나 MVVM 원리에 따르면 뷰모델마다 모델은 1개를 사용한다.
구글의 프레젠테이션은 모순적이다.
사람B:
One view model is standard. However, even google suggests that you may have more than one view model. That comes quite convenient when you mitgrate a phone app towards a tablet app. When you combind more than one phone views on a single tab view, then it is convenient re-using the models.
하나의 뷰모델이 표준이다. 그러나 구글은 너가 하나 이상의 뷰모델을 가질 수 있다고 했다. 이건 폰 앱에서 테이블 앱으로 이관될 때 굉장히 편하다. 하나 이상의 폰 뷰들을 하나의 탭 뷰로 합칠 때 모델을 재사용함에 편리하다.
If you have the SOLID principles in mind when coding, then the S (single responsibitly of a class) may cause you to use more than one view model.
코딩할 때 SOLID 원리를 따르는 자라면 S 는 하나의 뷰모델을 사용하게 한다. S 는 클래스는 단일 역할의 책임이 있다는 걸 뜻함.
However, one per view is pretty much standard and you shold have reasons, as metioned above, to use more than one.
그러나 뷰마다 하나가 있는 게 표준이며, 너는 위에 처럼 한 개 이상을 써야 하는 이유들도 있다.
https://stackoverflow.com/questions/44375276/when-using-mvvm-on-android-should-each-activity-have-one-and-only-one-viewmod?rq=1
When using MVVM on Android, should each Activity have one (and only one) ViewModel?
On MVVM pattern, the ViewModel contains business logic and notifies the View when it needs to be updated. It is also notified by the view about user events. As I understood it, each Model should h...
stackoverflow.com
사람A:
Don't place your ViewModel into another ViewModel. You should provide your ViewModel from ViewModelProviders. ViewModelProviders needs a context to create your ViewModel with given type.
뷰모델 안에 다른 뷰모델을 갖게 하지 말아라. ViewModelProviders 로부터 뷰모델을 제공할 수 있다.
There is nothing wrong with providing multiple ViewModel for a single activity.
단일 액티비티에 대해 여러 뷰모델을 제공하는 건 잘못되지 않았다.
사람B:
Sometimes you need composition in the view model layer though. Some view models can be "derived" from others. You don't want to have this logic in the presentation layer.
그래도 뷰모델 레이어에 콤포지션 해야 할 때가 있을 것이다. 어떤 뷰모델은 다른 것들로부터 "derived" 될 수 있다. 너는 프레젠테이션 레이어에서 이 로직을 갖길 원하지 않을 것이다.
https://github.com/googlesamples/android-architecture-components/issues/233
	
Can one viewmodel consist of another viewmodel · Issue #233 · googlesamples/android-architecture-components
I have DashBoardViewModel which will provide the data of message,news,events etc for my DashBoardActivity.So is it appropraite to use MessageViewModel,NewsViewModel etc as a member of DashBoardView...
github.com
사람A:
I think having multiple viewmodels per activity only increases complexity and I do not see any value in doing that.
액티비티마다 여러 뷰모델을 갖게 하는 건 복잡도를 올린다. 그리고 어느 가치도 없어 보인다.
사람B:
According to the open/closed principle, you should create three different ViewModels. The complexity isn't increased that much, and you are gaining the ability to move one ViewModel (or just reuse it) with the corresponding RecyclerView to the another Activity very easily.
o/cp 원리에 따르면, 3개의 다른 뷰모델을 만들어야만 한다. 복잡도는 많이 증가하지 않고, 하나의 뷰모델을 상응하는 리사이클러뷰와 함께 쉽게 다른 액티비티로 옮길 수 있는 능력을 갖게 된다.
https://stackoverflow.com/questions/46340106/activity-with-multiple-viewmodels
Activity with multiple ViewModels
I have an Activity that contains 3 RecyclerViews. I need populate RecyclerViews with data from remote repository (3 different requests). Can I use multiple ViewModels in the Activity, or is there any


Sure. You can have as many ViewModels as you want aslong as you bind them to a livecycle (activity, fragment).
원하는 만큼 뷰모델을 가질 수 있다. 라이프사이클이 있다.
