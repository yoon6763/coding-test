package baekjoon.bronze.b4

fun main() {
    val arr = readln().split(" ").map { it.toInt() }
    val n = readln().toInt()

    var total = 0.0

    repeat(n) {
        val (B, L, S) = readln().split(" ").map { it.toDouble() }
        if (S >= 17 && L >= 2.0) {
            total += arr[B.toInt()]
        }
    }

    println(total.toInt())
}
