package baekjoon.bronze.b3

fun main() {
    var sum = 0

    repeat(readln().toInt()) {
        val (h, b, k) = readln().split(" ").map { it.toInt() }
        sum += (b - h).coerceAtLeast(0) * k
    }

    println(sum)
}
