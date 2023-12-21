package baekjoon.bronze.b2


fun main() = repeat(readln().toInt()) {
    val (abc, num) = readln().split("-")
    val score = 26 * 26 * (abc[0] - 'A') + 26 * (abc[1] - 'A') + (abc[2] - 'A')
    println(if (Math.abs(score - num.toInt()) <= 100) "nice" else "not nice")
}