package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    // 소숫점 둘째 자리까지 출력
    println("$%.2f".format(readln().toDouble() * 0.8))
}