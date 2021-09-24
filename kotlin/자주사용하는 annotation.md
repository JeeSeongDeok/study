# 자주 사용하는 annotation

[다른 사람의 코드](https://github.com/skydoves/MarvelHeroes/blob/master/app/src/main/java/com/skydoves/marvelheroes/binding/RecyclerViewBinding.kt)를 보던 중 처음 보는 코드를 보고
 정리를 해봤다.<br>
 
 ## @JvmName
JVM 시그니처를 변경한다는 의미이다. 아래의 예시에서 쉽게 이해할 수 있다.

``` kotlin
// 컴파일 에러
fun foo(a : List<String>) {
    println("foo(a : List<String>)")
}

fun foo(a : List<Int>) {
    println("foo(a : List<Int>)")
}
```
두개의 함수는 바이트코드로 변경될 때 인자가 List<>로 시그니처가 동일하다. List의 generic이 구별하지 않기 때문에 두 개의 시그니처가 동일함.<br>
@JvmName을 사용하면 문제없이 컴파일이 가능하다.
```kotlin
@JvmName("fooListString")
fun foo(a : List<String>) {
    println("foo(a : List<String>)")
}

@JvmName("fooListInt")
fun foo(a : List<Int>) {
    println("foo(a : List<Int>)")
}
```
## @JvmStatic @JvmField
JvmStatic은 static의 get/set 변수를 자동으로 만들라는 의미이다.<br>
반면 JvmField는 get/set 변수를 만들지 말라는 의미이다.
```kotlin
class Bar {
    @JvmField
    var barSizes = 0
    companion object {
        @JvmStatic var barSize : Int = 0
    }
}
```
## @Throw
코틀린 함수가 예외로 던질 수 있다는 것을 표시한다. 
```kotlin
@Throws(NumberFormatException::class)
fun convertStringToInt(str: String) {
  ....
}
```
