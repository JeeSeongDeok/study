
### **kapt 이란?**

Kotlin Annotation Processing Tool이며, Annotation Processor는 자바 컴파일러의 플러그인 일종이다.

[kotlin Docs](https://kotlinlang.org/docs/kapt.html)에서는 찾아보니 자바 컴파일러에서 코틀린 annotation을 처리하기 위해서 사용되고 있다고 한다.

간단하게 말하면 Dagger, Databinding 등을 사용하기 위해서 kapt를 사용한다.

그러면 annotation이 무엇인가?

### **Annotation 이란?**

```kotlin
@HiltViewModel
class ViewModel @Inject constructor() : ViewModel() {
	// To do
}
@Singletone
object tempFunc {
	// To do
}
```

@Singletone, @HiltViewModel 등 자바 소스 코드에 추가 할 수 있는 메타 데이터의 한 형태이다.

애노테이션은 소스 파일에서 읽을 수도 있고, 컴파일러에 의해 생성된 클래스 파일에 내장되어 읽힐 수도 있으며, runtime에 java VM에 의해 유지되어 리플렉션에 의해 읽어 낼 수도 있다.

### **Annotation Processor 이란?**

 일반적으로 애노테이션은 코드베이스를 검사, 수정 또는 생성하는데 사용된다.

본질적으로 애노테이션 프로세서는 java 컴파일러의 플러그인 일종이다.

애노테이션 프로세서를 적재적소에 잘 사용한다면 개발자 코드를 단순화 할 수 있다. 

### **에러 해결법**

```kotlin
plugins {
    kotlin("kapt") version "1.6.0"
}

// 혹은

apply plugin: 'kotlin-kapt'
```
