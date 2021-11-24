# [Detecting camera features with Camera2](https://medium.com/google-developers/detecting-camera-features-with-camera2-61675bb7d1bf#.2x3icoqnc)

Camera2는 장치의 카메라에 직접 엑세스해야 하는 경우에 사용됨.<br>
카메라에 세부적인 수정이 필요없으면 Camera intent하는 방식이 제일 좋다.

### Camear2의 장점
- 최신 하드웨어에서 향상된 성능
- 더 빠른 간격으로 이미지 찰영
- 여러 카메라의 미리보기 표시
- 효과 및 필터를 직접 적용 가능

추가적으로 API를 요청해서 필요한 기능을 감지할 수 있다

### 예제) 전면 카메라 금지 시키기
먼저 기기에서 사용 가능한 카메라 목록을 가져와야한다. 
### Step 1: Camera 얻기
Camera2 API의 핵심은 CameraManager 클래스입니다.<br>
CameraManager를 통해서 getCameraIdList()를 사용하면 카메라 ID의 문자열 배열을 얻을 수 있습니다.<br> 
카메라 ID는 장치에서 사용할 수 있는 카메라를 나타냅니다. <br>
getCameraCharactertics() 메서드를 사용하여 카메라 ID를 전달하고 장치에 대해 사용 가능한 설정 및 출력 매개변수를 가져올 수 있습니다.
```kotlin
 val manager = getSystemService(CAMERA_SERVICE) as CameraManager

        try{
            for (cameraId in manager.cameraIdList){
                // 기기에서 사용 가능한 카메라 목록을 가져온다.
                val char = manager.getCameraCharacteristics(cameraId)
            }
        } catch (e: CameraAccessException){
            e.printStackTrace()
        }
```
### Step 2: characteristics 요청
CameraCharacteristics 개체가 있으면 장치에서 사용 가능한 특성을 요청할 수 있습니다.<br>
get() 메서드는 CameraCharacteristic 필드를 예상하고 필드값을 반환합니다.
```kotlin
// 전면 카메라 여부를 get함
val fancing = char.get(CameraCharacteristics.LENS_FACING)
```

### Step 3: 전면 카메라 금지
LENS_FANCING_FRONT를 이용해서 전면 카메라를 감지하면 된다.
```kotlin
    private fun detectedSelfieCamera(cameraId:String){
        val char = manager.getCameraCharacteristics(cameraId)
        val fancing = char.get(CameraCharacteristics.LENS_FACING)
        if(fancing != null && fancing == CameraCharacteristics.LENS_FACING_FRONT){
            // 전면 카메라가 아님
        } else {
            // 전면 카메라가 맞음
        }
    }
```
더 많은 예제를 보고 싶으면 아래 GitHub를 참고하면 된다.
[예제 깃허브](https://github.com/googlearchive/android-Camera2Basic/tree/master/kotlinApp)
