package baekjoon.bronze.b3

fun main() {
    val INF = 601
    var sum = INF

    repeat(readln().toInt()) {
        val temp = readln().split(" ").sumOf { it.toInt() }
        if (temp >= 512) sum = minOf(temp, sum)
    }

    println(if (sum == INF) -1 else sum)
}