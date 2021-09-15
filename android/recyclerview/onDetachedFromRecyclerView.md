# onDetachedFromRecyclerView

참고
[블로그](https://ppizil.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-Recyclerview-%EC%A0%9C%EB%8C%80%EB%A1%9C-%EC%95%8C%EA%B3%A0-%EC%93%B0%EC%9E%90)

RecyclerView는 View를 재사용하는 리스트 형식 뷰이다.
RecyclerView의 아이템은 아래로 스크롤하면 바로 사라지는 것은 아니다.
RecyclerView의 아이템은 사라짐과 동시에 onDetachedFromRecyclerView가 발생된다.

만약 onDetachedFromRecyclerView에서 따로 작업을 하지 않는다면 메모리 누수가 발생될 수 있다.
TextView, EditView와 같이 라이프사이클을 가진 뷰는 알아서 회수가 된다고 하지만 이미지 혹은 동영상 플레이어등 그래픽 관련 된 것들은 바로 파괴되지 않고 메모리에 상주가 된다.
이런 친구들을 익명 인스턴스 혹은 잘못된 코드로 작성하면 메모리 누수가 발생한다. 

따라서, 그래픽 관련된 작업을 할 때 회수를 명시적으로 진행해야 한다.
