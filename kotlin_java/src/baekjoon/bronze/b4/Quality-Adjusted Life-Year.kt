package baekjoon.bronze.b4

fun main() {
    var ans = 0.0

    repeat(readln().toInt()) {
        val (q, y) = readln().split(" ").map { it.toDouble() }
        ans += q * y
    }

    println("%.3f".format(ans))
}
