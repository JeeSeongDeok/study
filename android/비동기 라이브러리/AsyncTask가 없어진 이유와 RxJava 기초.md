# Rxjava + Retrofit2
참고주소
[Android AsyncTask Deprecated](https://www.techyourchance.com/asynctask-deprecated/)
[[Android] RxJava2 + Retrofit2](https://dev-eunji.tistory.com/20)
[Rxjava - 스케쥴러란?](https://yunzai.dev/posts/RxJava_%EC%8A%A4%EC%BC%80%EC%A5%B4%EB%9F%AC%EB%9E%80_%EC%8A%A4%EC%BC%80%EC%A5%B4%EB%9F%AC%EC%9D%98_%EC%A2%85%EB%A5%98(1)/)

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
그래서 [RxJava](https://github.com/ReactiveX/RxAndroid) + [Retorfit2](https://github.com/square/retrofit)를 사용해볼려고 한다.

``` kotlin
@GET("Docfriends_Android_Recruit/api/home.json")
    fun getData(): Single<PageData>
```
 Single클래스는 오직 한개의 데이터만 발행할 수 있다.
 <img src = "https://raw.github.com/wiki/ReactiveX/RxJava/images/rx-operators/Single.legend.png">
 이 클래스는 한개의 데이터가 발행될 시 바로 종료된다는 특징이 있다. 
``` kotlin
// Retrofit2 Client
val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) //RxJava Adapter를 추가한다.
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    return retrofit.create(APIService::class.java)
```
Retrofit2에서는 addCallAdapterFactory를 사용해서 RxJava Adapter를 넘길 수 있다.
``` kotlin
val getDataObserver:Single<PageData> = getData()
        .subscribeOn(Schedulers.io()) // 스케쥴러 지정
        .observeOn(AndroidSchedulers.mainThread()) // UI 수정을 위해 mainThread를 부름
```

Rxjava 스케쥴러
- 비동기 쓰레드를 위한 Thread 관리자이다.
- RxJava의 스케쥴러를 통해 쓰레드를 위한 코드의 간결성 및 쓰레드 관리의 복잡함을 줄일 수 있다.
- 생산자쪽의 데이터 흐름을 제어하기 위해서는 subscribeOn() 연산자를 사용한다.
- 소비자쪽에서 전달받은 데이터 처리를 제어하기 위해서는 observeOn() 연산자를 사용한다.

스케쥴러 종류
- Schdulers.io()
  - 네트워크 요청 처리, 각종 입/출력 작업, 데이터베이스 쿼리 등에 사용
  - 쓰레드 풀에서 쓰레드를 가져오거나 가져올 쓰레드가 없으면 새로운 쓰레드를 생성한다.
- Schdulers.computation()
  - 논리적인 연산 처리 시, 사용하는 스케쥴러
  - CPU 코어의 물리적 쓰레드 수를 넘지 않는 범위에서 쓰레들르 생성한다.
  - 대기 시간 없이 빠르게 계산 작업을 수행하기위해 사용한다. 
- Schdulers.newThread()
  - 요청시마다 매번 새로운 쓰레드를 생성한다.
  - 매번 생성되면 쓰레드 비용도 많이 들고, 재사용도 되지 않는다.

``` kotlin
 model.getData().subscribe({
        // onSuccess
        // ToDo Anything
        },{
        // onFailed
        })
 ```
 이 후 .subscribe를 통해 비동기 처리를 할 수 있다. 여기서는 Single을 사용해 onSuccess, onFailed만 있다.
