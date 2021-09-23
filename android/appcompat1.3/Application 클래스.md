# Application 클래스

참고주소 - [안드로이드 가이드](https://developer.android.com/reference/kotlin/android/app/Application)

 Application 클래스는 각자의 액티비티에서 공통되게 사용할 수 있도록 만들어주는 클래스이다. 나 같은 경우는 Repository나 sharedpreferences를 사용하기 위해 이 클래스를 사용해봤다.<br>
 
 Application 클래스는 안드로이드 가이드에서 아래와 같이 정의하고 있다.
 ```
 The Application class, or your subclass of the Application class,
 Application 클래스 또는 Application 클래스의 하위 클래스는 
 
 is instantiated before any other class when the process for your application/package is created.
 애플리케이션/패키지에 대한 프로세스가 생성될 때 다른 클래스보다 먼저 인스턴스화됩니다.
 ```
 
 안드로이드 가이드에서는 Application 클래스는 정적 싱글톤 방식보다는 모듈화 방식을 사용하면 동일한 기능을 제공할 수 있다고 한다.
 
 ```kotlin
class App : Application(){
    doAnything()
}
 ```
