package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    readLine()
    var problemCount = 0
    while (true) {
        val s = readLine()
        if (s == "고무오리 디버깅 끝") break
        if (s[0] == '문') problemCount++
        else problemCount--
        if (problemCount < 0) problemCount = 2
    }
    println(if (problemCount == 0) "고무오리야 사랑해" else "힝구")
}
