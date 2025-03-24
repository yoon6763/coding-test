package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine().split(" ").map(String::toInt)
    var max = 0
    repeat(readLine().toInt()) {
        val skill = List(3) { readLine().split(" ").map(String::toInt) }
        var tmp = 0
        repeat(3) {
            tmp += skill[it][0] * a + skill[it][1] * b + skill[it][2] * c
        }
        max = max.coerceAtLeast(tmp)
    }
    print(max)
}