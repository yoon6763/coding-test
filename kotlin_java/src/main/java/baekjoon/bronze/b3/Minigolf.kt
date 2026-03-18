package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val shots = readln().split(" ").map { it.toInt() }
    var result = 0

    for (i in 0 until n) {
        val stroke = minOf(shots[i], 7)
        val par = if ((i + 1) % 2 == 1) 2 else 3
        result += (stroke - par)
    }

    println(result)
}