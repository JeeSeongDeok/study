# Network Interface
``` kotlin
    @Test
    fun `IP 얻어오기 테스트`() {
        var ip: String? = null
        val en = NetworkInterface.getNetworkInterfaces()
        while (en.hasMoreElements()) {
            val networkInterface = en.nextElement()
            val inetAddressEnum = networkInterface.inetAddresses
            while (inetAddressEnum.hasMoreElements()) {
                val inetAddress = inetAddressEnum.nextElement()
                if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                    ip = inetAddress.hostAddress!!.toString()
                }
            }
        }
        assertNull(ip)
    }
```
<p> 테스트 코드를 짜는 중에 NetworkInterface는 어떤 것을 가지고 있는지 궁금해서 시작함 </p>

![image](https://user-images.githubusercontent.com/23256819/167741996-bbe2090c-3091-4145-bc13-fec823df6e20.png)
![image](https://user-images.githubusercontent.com/23256819/167742026-7c36e928-d379-4658-a760-b7e952aac5e6.png)

<p> 모든 인터넷 종류들을 하나하나식 다 불러서 비교 후, 이게 Inet4Adress인지 확인 후 ip를 리턴하는 형식이다. </p>

![제목 없음](https://user-images.githubusercontent.com/23256819/167971253-999d0d8d-3f3e-4863-9b6c-b69363d30c5a.png)
