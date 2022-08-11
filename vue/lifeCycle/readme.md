라이프사이클 

1. beforeCreate -> 인스턴스가 생성되고 첫 실행. data, method 정의 x, 화면 요소 접근 x
2. Create -> data, method 정의. 화면 요소 접근 x
3. beforeMound -> render() 함수가 호출되기 직전 상태 (render는 화면 요소(돔)을 그리는 함수)
4. mounted -> 화면 요소에 접근 가능
5. beforeUpdate -> 뷰의 반응성을 넣기 전 화면을 다시 그리기 전 상태
6. Update -> 데이터가 변경되고나서 화면을 다시 그리고 난 상태
7. beforeDestroy -> 뷰 인스턴스가 파괴되기 직전에 호출되는 단계.
8. Destory -> 뷰 인스턴스가 파괴되고 난 뒤 단계. 인스턴스도 
