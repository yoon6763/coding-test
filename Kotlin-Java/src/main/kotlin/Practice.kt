fun main() {
    val testP2 = ::testPrintln
    testP2()
}

fun testPrintln() {
    println("Hello World!")
}


// lambda function
fun String.printIf(func: (Char) -> Boolean) {
    // val str = "Hello World Kotlin"
    // str.printIf 와 같이 사용하면 str를 this로 받을 수 있음.

    this.forEach {
        // str내 문자 하나하나를 it으로 받음.
        // func(it)는 func의 인자로 it를 넣어서 실행한 결과를 받음.
        // str.printIf { it.isUpperCase() } 라고 사용하면
        // func(it)는 .isUpperCase()를 실행한 결과를 받음.
        if (func(it)) print(it)
    }
}