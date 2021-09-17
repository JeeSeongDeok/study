# LayoutInflator란?
 XML에 표기된 레이아웃들을 실제 메모리에 올려주는 역할을 한다. 즉 XML에 정의된 Resource를 view객체로 반환하는 역활<br>
 setContentView 또한 inflater 역할을 한다.
 
 <img src ="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FmtLIe%2FbtqytUl5eEW%2Fkkss38KNJzjgQJL5kVxf6K%2Fimg.jpg">
 
## ViewBinding에서 inflate
 ```kotlin
 // ActivityMain의 xml파일을 메모리에 올리고 뷰 객체로 반환하는 과정
 binding = ActivityMainBinding.inflate(layoutInflater)
 setContentView(binding.root)
 ```
