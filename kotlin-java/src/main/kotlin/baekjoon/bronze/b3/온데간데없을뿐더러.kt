package baekjoon.bronze.b3

fun main() {
    readln()
    // 문자열 내 공백 제거
    println(List(2) { readln().replace(" ", "").toLong() }.min())
}