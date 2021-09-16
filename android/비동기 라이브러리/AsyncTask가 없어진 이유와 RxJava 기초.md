# Rxjava + Retrofit2
참고주소
[Android AsyncTask Deprecated](https://www.techyourchance.com/asynctask-deprecated/)
[[Android] RxJava2 + Retrofit2](https://dev-eunji.tistory.com/20)

Android AsyncTask가 Deprecated 되었다. 구글에서 deprecated한 이유는 아래와 같다.<br>
    
    AsyncTask was intended to enable proper and easy use of the UI thread.
    -> AsyncTask는 UI thread(혹은 MainThread)를 쉽고 적절하게 사용했었다. 
    However, the most common use case was for integrating into UI, 
    -> 그렇지만, 일반적인사례에서는 UI에 통합하는 것이고
    and that would cause Context leaks, missed callbacks, or crashes on configuration changes. 
    -> 이로인해 Context leaks, 콜백 미스, 구성 변경에 크래시가 생겼다.
    It also has inconsistent behavior on different versions of the platform, swallows exceptions from doInBackground,
    -> 또한, 다른 버전 플랫폼에서 똑같이 처리되지 않고, 백그라운드작업(doInBackground)에서 예외처리하고
    and does not provide much utility over using Executors directly.
    -> Executors를 사용하는 것보다 더 많은 유틸리티를 제공하지 않는다
    
 이러한 이유로 구글에서는 AsyncTask를 Deprectaed를 했고, 구글에서는 Coroutine를 권장하고 있다.<br>
구글에서 코루틴을 권장하고 있지만, 개발자들은 Rxjava도 많이 사용하고 있다.<br>
그래서 [RxJava](https://github.com/ReactiveX/RxAndroid)를 사용해볼려고 한다.

``` kotlin
val clark = Person()
clark.name = "Clark"
clark.age = 18
```
