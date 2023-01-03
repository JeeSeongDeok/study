# Clean Code 정리



## 2장 의미있는 이름

### 클래스 이름 
- 명사 또는 명사구가 적절하다고 함.
좋은 예) Customer, WikiPage, Account, AddressParser 등등
안좋은 예) Manager, Processor, Data, Info 등등

### 메서드 이름
- 동사나 동사구가 적합하다고 함.
좋은 예) postPayment, deletePage, save 등

### 접근자(Accessor), 변경자(Mutator), 조건자(Predicate)는 get, set, is를 붙인다.

### 생성자를 만들 때
Weather myWeather = new Weather(0, 0); 보다는
Weather myWeather = Weather.setXY(0, 0); 가 메서드 인수를 설명하는 이름을 가지고 있어서 더 적합하다고 함.

### 한 개념에 하나의 단어를 사용해라.
- Manager와 Controller는 같은 개념인데 둘 다 사용하는 경우가 있을 거다. 같은 개념이지만 둘 다 사용하는 경우 일관성이 없어 다른 기능을 사용할 것이라고 생각한다.



