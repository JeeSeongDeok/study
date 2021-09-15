# Deprecated된 startActivityResult(), startActivityForResult()

참고주소
[안드로이드 가이드](https://developer.android.com/training/basics/intents/result)

``` kotlin
var resultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
    if (result.resultCode == Activity.RESULT_OK) {
        // There are no request codes
        val data: Intent? = result.data
        doFunction()
    }
}

fun openAnyActivityForResult() {
    val intent = Intent(this, AnyActivity::class.java)
    resultLauncher.launch(intent)
}
```
