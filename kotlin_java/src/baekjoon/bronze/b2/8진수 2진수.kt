package baekjoon.bronze.b2

fun main() {
    // 8진수 -> 2진수
    // 8진수 1은 2진수 010, 8진수 2는 2진수 011, 8진수 3은 2진수 100
    val parser = arrayOf("000", "001", "010", "011", "100", "101", "110", "111")

    val str = readln()

    if (str == "0") {
        println(0)
        return
    }

    val sb = StringBuilder()

    for (c in str) {
        sb.append(parser[c.digitToInt()])
    }

    // 시작부분 0 제거
    println(sb.trimStart { it == '0' })
}

// 3 1 4
// 011 001 100
// 11001100