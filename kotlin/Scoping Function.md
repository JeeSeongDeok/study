# 코틀린 Scoping Function (apply, with, let, also, run)

- 참고주소
  - [깃 허브 주소](https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%9D%98-apply-with-let-also-run-%EC%9D%80-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94%EA%B0%80-4a517292df29) 
  - [Scope Function 차이점](https://docs.google.com/spreadsheets/d/1P2gMRuu36pSDW4fdwE-fLN9fcA_ZboIU2Q5VtgixBNo/edit#gid=0)

## apply
수신 객체 자신을 다시 반환하려는 경우 사용함

예제
``` kotlin
val peter = Person().apply {
    name = "Peter"
    age = 18
}
```
사용하지 않는 경우 
``` kotlin
val clark = Person()
clark.name = "Clark"
clark.age = 18
```

## also 
전달된 수신 객체를 전혀 사용하지 않는 경우 혹은 수신 객체의 속성을 변경하지 않고 사용하는 경우

예제
``` kotlin
class Book(author: Person) {
    val author = author.also {
      requireNotNull(it.age)
      print(it.name)
    }
}
```
사용하지 않는 경우

``` kotlin
class Book(val author: Person) {
    init {
      requireNotNull(author.age)
      print(author.name)
    }
}
```

## let
지정된 값이 null이 아닌 경우 또는 Nullable 객체를 다른 Nullable 객체로 반환하는 경우 또는 단일 지역 변수 범위를 제한하는 경우

``` kotlin
// null 이 아닐때만 실행됩니다.
getNullablePerson()?.let {
    promote(it)
}

// nullable personal객체를 nullable driversLicence 객체로 변경합니다.
val driversLicence: Licence? = getNullablePerson()?.let {
    licenceService.getDriversLicence(it) 
}
// 변수 dao 의 범위는 이 블록 안 으로 제한 됩니다.
val person: Person = getPerson()
getPersonDao().let { dao -> 
    dao.insert(person)
}
```

사용하지 않는 경우
``` kotlin
// null이 아닐 경우
val person: Person? = getPromotablePerson()
if (person != null) {
  promote(person)
}
// Nullable 객체를 다른 Nullable 객체로 반환하는 경우
val driver: Person? = getDriver()
val driversLicence: Licence? = if (driver == null) null else
    licenceService.getDriversLicence(it)
// 단일 지역 변수 범위를 제한하는 경우
val person: Person = getPerson()
val personDao: PersonDao = getPersonDao()
personDao.insert(person)
```

## with
Non-nullable 수신 객체, 결과가 필요하지 않는 경우
``` kotlin
val person: Person = getPerson()
with(person) {
    print(name)
    print(age)
}
```

사용하지 않는 경우

``` kotlin
val person: Person = getPerson()
print(person.name)
print(person.age)
```

## run
어떤 값을 계산할 필요가 있는 경우 또는 여러개의 지역 변수의 범위를 제한할려는 경우
``` kotlin
val inserted: Boolean = run {
    // person 과 personDao 의 범위를 제한 합니다.
    val person: Person = getPerson()
    val personDao: PersonDao = getPersonDao()
    // 수행 결과를 반환 합니다.
    personDao.insert(person)
}
fun printAge(person: Person) = person.run {
    // person 을 수신객체로 변환하여 age 값을 사용합니다.
    print(age)
}
```

사용하지 않는 경우
``` kotlin
val person: Person = getPerson()
val personDao: PersonDao = getPersonDao()
val inserted: Boolean = personDao.insert(person)
fun printAge(person: Person) = {
    print(person.age)
}
```

