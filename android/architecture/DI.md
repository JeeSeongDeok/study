# DI
참고주소 - [Spoqa 기술 블로그](https://spoqa.github.io/2020/11/02/android-dependency-injection-with-koin.html)
<img src = "https://spoqa.github.io/images/2020-11-02/dependency_injection.png">
<p align="center">DI(Depedency Injection, 의존성 주입)이란 클래스 내부에서 객체를 생성하지 않고, 외부에서 객체를 생성해 주입하는 방식</p>

## DI를 적용하는 이유

```kotlin
class Manager { ... }

class DodoCart {
    val manager = Manager()
    ...
}

class DodoPoint {
    val manager = Manager()
    ...
}

fun main() {
    val dodoCart = DodoCart()
    val dodoPoint = DodoPoint()
}
```
1. Manger클래스가 변경되면 DodoCart와 DodoPoint 클래스는 Manager클래스에 의존하고 있으므로 변경되어야 한다.
2. DodoCart와 DodoPoint는 실제로 Manager 객체를 사용해서 단위 테스팅할 때 어렵다.

```kotlin
class Manager { ... }

class DodoCart(val manager: Manager) { ... }

class DodoPoint(val manager: Manager) { ... }

fun main() {
    val manager = Manager()
    val dodoCart = DodoCart(manager)
    val dodoPoint = DodoPoint(manager)
}
```
main 함수에서 manager를 주입했기 때문에 문제점을 해결할 수 있었다.

## 안드로이드에서의 DI
 안드로이드에서 Activity 또는 Fragment에서 객체를 생성할 때 context가 계속 바뀌기 때문에 같은 클래스 타입이여도 다르게 동작할 수 있다.
 Activity 또는 Fragment에서 객체를 주입 받아 사용하는 식으로 구현하면 context의 영향을 받지 않고 공통으로 재사용할 수 있는 객체를 구현할 수 있다.
 
