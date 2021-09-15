# lateinit, Lazy 차이

## lateinit
1. lateinit은 null 값으로 초기화할 수 없다.
2. 초기화 전 변수를 사용할 수 없다.

## Lazy
1. 호출 시 lazy{}의 정의에 의해서 초기화한다.
2. 기본적으로 Synchronized을 사용한다.
