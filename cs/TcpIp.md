[참고주소](https://medium.com/@rlatla626/tcp-ip-%EC%A0%95%EB%A6%AC-204e8a986d98)
# TCP
Transmission Control Protocol 데이터 전달 규칙을 의미함
데이터를 보낼 때 한번에 보내는 것이 아닌 잘게 나누어서(패킷) 보내는 방식을 사용함

## MTU
Maximum Transmission Unit는 패킷의 최대 크기를 나타내는 수치를 의미함
전송할 데이터가 MTU보다 값이 크다면 패킷으로 나누어서 보내지게 된다.

MTU 값이 크면, 패킷의 수가 그만큼 줄어들기 때문에한번에 많은 데이터를 보낼 수 있으므로 대량의 데이터를 처리할때 이점이 있지만, 패킷이 훼손되어 오는 경우에는 다시 큰 패킷을 요청해야하는데, 패킷이 큰 만큼 오는데 오래 걸리게 된다.
MTU값이 작으면 패킷의 수가 많아지는데, 패킷이 가지고 있는 공통 header (TCP Header & IP Header)들을 처리하는 양이 늘어나므로 overhead가 늘어나는 문제가 있다.

## TCP Header
![0_MXlKBHg6V5kONBlg](https://user-images.githubusercontent.com/23256819/137582828-a518af52-3388-40ee-9d43-869aaebeccc8.png)
데이터를 받는쪽은 A-2,A-10,…, A-1 데이터를 순서에 맞게 A-1,A-2,…,A-10으로 재조립 한다.
순서에맞게 재조립이 가능한 이유는, TCP 방식으로 데이터 전송시 Header가 붙게되는데 Header에 순서에 관한 정보(Sequence Number)가 있기 때문이다.
TCP헤더에 설명을 약간 붙이자면
Source Port는 송신측의 port 번호를 나타낸다.
Destination Port는 수신측의 port번호를 나타낸다.
CheckSum은 패킷의 훼손여부를 체크하는 역할을 한다.
SYN은 통신을 하는 양측의 Sequence Number를 동기화 하기위해 사용된다.
ACK는 데이터를 잘 받았다는 응답을 전달하기 위해 사용되며 Sequence Number에 + 1을 붙이는 방법을 이용한다.

![1_sNHe2dPAn0DSy2wn_j0Qxg](https://user-images.githubusercontent.com/23256819/137582870-7489a189-5704-412a-8961-56c9d0a10f0f.png)
TCP/IP 4계층을 간단히 정리하면
1계층, 네트워크 액세스 계층(Network Access Layer or Network Interface Layer) : 하드웨어 적인 요소를 담당한다. MAC 주소를 이용해 신뢰성 있는 전송을 보장한다.(OSI 7 계층에서 1,2 계층 역할.)
2계층, 인터넷 계층(Internet Layer) : IP헤더를 붙여서 패킷을 만들어 전송하는 역할을 한다. (OSI 7 계층에서 3계층 역할.)
3계층, 전송 계층(Transport Layer) : 두 지점의 신뢰성 있는 데이터 전송 역할을 한다. IP와 PORT를 이용해 프로세스와 통신한다. (OSI 7 계층에서 4계층 역할.)
4계층, 응용 계층((Application Layer) : 응용프로그램들이 이용 할 수 있는 인터페이스를 제공한다. 대표 프로토콜로는 HTTP, FTP, Telnet 등이 있음. (OSI 7 계층에서 5,6,7계층 역할.)
